package me.henry.dotconvert.log.task;

import java.util.ArrayList;

public class TaskLogger implements TaskLoggerImpl {
    private ArrayList<String> log = new ArrayList<>();

    @Override
    public void addLogItem(String item) {
        log.add(item);
    }

    @Override
    public void replaceLogItem(String item, Integer index) {
        log.set(index, item);
    }

    @Override
    public ArrayList<String> getLog() {
        return log;
    }

    @Override
    public Integer getLogLength() {
        return log.size();
    }
}
