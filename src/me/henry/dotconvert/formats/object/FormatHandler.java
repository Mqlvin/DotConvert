package me.henry.dotconvert.formats.object;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import me.henry.dotconvert.DotConvert;
import me.henry.dotconvert.formats.map.FormatMapper;
import me.henry.dotconvert.io.Readers;
import me.henry.dotconvert.json.KeyHandler;

import java.io.File;
import java.util.ArrayList;

public class FormatHandler {
    public static ArrayList<FormatType> formats = new ArrayList<>();
    public static JsonObject savedFormats = new JsonObject();
    public static JsonObject fileMap = new JsonObject();

    public static void registerTypes() {
        savedFormats = new JsonParser().parse(Readers.readJson(new File(DotConvert.installLocation + "\\formats\\formats.json"))).getAsJsonObject();
        fileMap = new JsonParser().parse(Readers.readJson(new File(DotConvert.installLocation + "\\formats\\file_map.json"))).getAsJsonObject();
        for(String extension : KeyHandler.getAllProperties(savedFormats)) {
            generateFormatType(extension);
        }
        FormatMapper.formatMaps(formats, fileMap);
    }

    public static FormatType generateFormatType(String extension) {
        FormatType format = new FormatType(extension, FormatCategories.valueOf(savedFormats.get(extension).toString().replace("\"", "").toLowerCase()));
        ArrayList<String> conversionList = new Gson().fromJson(new JsonParser().parse(fileMap.get(extension).toString()).getAsJsonArray(), new TypeToken<ArrayList<String>>(){}.getType());
        for(String formatToAdd : conversionList) {
            format.addConversionType(formatToAdd);
        }
        return format;
    }
}
