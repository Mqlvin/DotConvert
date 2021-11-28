package me.henry.dotconvert.command;

import me.henry.dotconvert.log.Log;

import java.util.ArrayList;

public class CommandExecutor implements CommandImpl {
    private String command = "";
    private ArrayList<String> output = new ArrayList<>();
    private Boolean complete = false;
    private Boolean doOutput = true;

    public CommandExecutor(String command) {
        this.command = "cmd /c " + command;
        this.complete = false;
    }

    @Override
    public void executeCommand() {
        CommandAPI.executeCommand(this);
        if(doOutput) {
            while(complete == false) {
                try {
                    Thread.sleep(5);
                } catch(Exception e) {
                    Log.exception(e.toString());
                }
            }
        }
    }

    @Override
    public void setCommand(String command) {
        this.command = "cmd /c " + command;
    }

    @Override
    public void addOutput(String line) {
        this.output.add(line);
    }

    @Override
    public void wantOutput(Boolean bool) {
        this.doOutput = bool;
    }

    @Override
    public ArrayList<String> getOutput() {
        return this.output;
    }

    @Override
    public String getCommand() {
        return this.command;
    }

    @Override
    public void processComplete() {
        complete = true;
    }
}
