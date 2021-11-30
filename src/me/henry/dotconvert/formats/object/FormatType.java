package me.henry.dotconvert.formats.object;

import java.util.ArrayList;

public class FormatType implements FormatTypeImpl {
    private ArrayList<String> convertsTo = new ArrayList<>();
    private Enum<FormatCategories> type;
    private String extension;

    public FormatType(String extension, Enum<FormatCategories> type) {
        this.extension = extension;
        this.type = type;
    }

    @Override
    public void addConversionType(String type) {
        convertsTo.add(type);
    }

    @Override
    public ArrayList<String> getConversionTypes() {
        return convertsTo;
    }

    @Override
    public String getExtension() {
        return extension;
    }
}
