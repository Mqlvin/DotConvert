package me.henry.dotconvert.format.type;

import java.util.ArrayList;

public interface FormatImpl {
    public String getExtension();
    public FormatObjectType getType();
    public ArrayList<FormatObject> getConversionsTypes();
    public ArrayList<String> getConversionsList();
    public String getProgID();
    public String getIcoPath();

    public void addConversion(FormatObject format);
}
