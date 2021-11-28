package me.henry.dotconvert.command;

import java.util.ArrayList;

public interface CommandImpl {
    public void executeCommand();
    public void setCommand(String command);
    public void addOutput(String line);
    public void wantOutput(Boolean bool);

    public ArrayList<String> getOutput();
    public String getCommand();

    public void processComplete();
}
