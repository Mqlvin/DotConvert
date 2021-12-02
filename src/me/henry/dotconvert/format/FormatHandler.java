package me.henry.dotconvert.format;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import me.henry.dotconvert.DotConvert;
import me.henry.dotconvert.format.type.FormatObject;
import me.henry.dotconvert.format.type.FormatObjectType;
import me.henry.dotconvert.io.Readers;
import me.henry.dotconvert.json.KeyHandler;

import java.io.File;
import java.util.ArrayList;

public class FormatHandler {
    public static ArrayList<FormatObject> formats = new ArrayList<>();

    public static void loadFormats() {
        JsonObject formatConfig = new JsonParser().parse(Readers.readJson(new File(DotConvert.installLocation + "\\formats\\format_config.json"))).getAsJsonObject();
        for(String formatKey : KeyHandler.getAllProperties(formatConfig)) {
            formats.add(new FormatObject(formatKey.toLowerCase().replace("\"", ""), FormatObjectType.valueOf(formatConfig.get(formatKey.toLowerCase().replace("\"", "")).toString().replace("\"", "").toUpperCase())));
        }
        for(FormatObject format : formats) {
            for(FormatObject format_ : formats) {
                if(format.getType().equals(format_.getType()) && !format.equals(format_)) {
                    format.addConversion(format_);
                }
            }
        }
    }
    /*
    Loads all formats for now, can optimise this later if I need to!
     */

    public static FormatObject getObjectFromExtension(String extension) {
        for(FormatObject format : formats) {
            if(format.getExtension().equalsIgnoreCase(extension)) {
                return format;
            }
        }
        return null;
    }
}
