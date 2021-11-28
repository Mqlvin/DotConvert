package me.henry.dotconvert.registry;

import me.henry.dotconvert.command.CommandExecutor;

import java.util.ArrayList;

public class RegistryHandler {
    public static ArrayList<String> query(String keyname, String valuename) {
        CommandExecutor executor = new CommandExecutor("reg query \"" + keyname + "\" /v \"" + valuename + "\"");
        executor.executeCommand();
        return executor.getOutput();
        /*
        For example:
        reg query "HKCU\Software\Microsoft\Windows\CurrentVersion\Explorer\FileExts\.mp3\OpenWithList" /v "valuename"
         */
    }

    public static ArrayList<String> query(String keyname) {
        CommandExecutor executor = new CommandExecutor("reg query \"" + keyname + "\"");
        executor.executeCommand();
        return executor.getOutput();
        /*
        For example:
        reg query "HKCU\Software\Microsoft\Windows\CurrentVersion\Explorer\FileExts\.mp3\OpenWithList"
         */
    }

    public static void addKey(String keyname) {
        if(query(keyname).size() == 0) {
            CommandExecutor executor = new CommandExecutor("reg add \"" + keyname + "\"");
            executor.executeCommand();
        }
        /*
        For example:
        reg add "HKCR\jpegfile\shell\dotconvert\shell"
        Note: This recursively creates keys.
         */
    }

    public static void addEntry(String location, String name, String data, Enum<RegistryTypes> type) {
        CommandExecutor executor = new CommandExecutor("reg add \"" + location + "\" /v \"" + name + "\" /t \"" + type.toString() + "\" /d \"" + data + "\" /f");
        executor.executeCommand();
        /*
        For example:
        reg add "HKCR\jpegfile\shell\dotconvert" /v "MUIVerb" /t "REG_SZ" /d "Convert to..." /f
         */
    }
}
