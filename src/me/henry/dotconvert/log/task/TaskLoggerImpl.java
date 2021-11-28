package me.henry.dotconvert.log.task;

import java.util.ArrayList;

public interface TaskLoggerImpl {
    public void addLogItem(String item);
    public void replaceLogItem(String item, Integer index);

    public ArrayList<String> getLog();
    public Integer getLogLength();
}
