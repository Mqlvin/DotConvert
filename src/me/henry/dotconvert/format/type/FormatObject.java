package me.henry.dotconvert.format.type;

import me.henry.dotconvert.format.FormatAssociations;

import java.io.File;
import java.text.Normalizer;
import java.util.ArrayList;

public class FormatObject implements FormatImpl {
    private FormatObjectType type;
    private String extension;
    private ArrayList<FormatObject> conversions = new ArrayList<>();
    private ArrayList<String> conversionsString = new ArrayList<>();
    private String progID;
    private String icoPath;

    public FormatObject(String extension, FormatObjectType type) {
        this.type = type;
        this.extension = extension;

        this.progID = FormatAssociations.getProgID(extension);
        this.icoPath = FormatAssociations.getFormatIcon(extension);
    }

    @Override
    public String getExtension() {
        return this.extension;
    }

    @Override
    public FormatObjectType getType() {
        return this.type;
    }

    @Override
    public ArrayList<FormatObject> getConversionsTypes() {
        return conversions;
    }

    @Override
    public ArrayList<String> getConversionsList() {
        return conversionsString;
    }

    @Override
    public String getProgID() {
        return this.progID;
    }

    @Override
    public String getIcoPath() {
        return this.icoPath;
    }

    @Override
    public void addConversion(FormatObject format) {
        conversions.add(format);
        conversionsString.add(format.getExtension());
    }
}
