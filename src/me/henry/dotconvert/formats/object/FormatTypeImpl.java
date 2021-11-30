package me.henry.dotconvert.formats.object;

import java.text.Normalizer;
import java.util.ArrayList;

public interface FormatTypeImpl {
    public void addConversionType(String type);

    public ArrayList<String> getConversionTypes();
    public String getExtension();
}
