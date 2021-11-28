package me.henry.dotconvert.command;

import me.henry.dotconvert.log.Log;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CommandAPI {
    /*
    This class cannot call an execution on the CommandExecutor's command, or else an infinite loop will occur.
     */
    public static void executeCommand(CommandExecutor executor) {
        try {
            final Process process = Runtime.getRuntime().exec(executor.getCommand());
            new Thread(() -> {
                BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream()));
                String line = null;
                try {
                    while((line = br.readLine()) != null) {
                        if(!line.equalsIgnoreCase("") && !line.equalsIgnoreCase("\n") && !line.equalsIgnoreCase(" ")) {
                            executor.addOutput(line);
                        }
                    }
                } catch(Exception e) {
                    Log.exception(e.toString());
                }
                executor.processComplete();
            }).start();
        } catch(Exception e) {
            Log.exception(e.toString());
        }
    }
}
