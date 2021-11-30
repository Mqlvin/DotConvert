package me.henry.dotconvert.formats.map;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import me.henry.dotconvert.DotConvert;
import me.henry.dotconvert.formats.object.FormatType;
import me.henry.dotconvert.formats.object.FormatCategories;
import me.henry.dotconvert.io.Writers;

import java.io.File;
import java.util.ArrayList;

public class FormatMapper {
    public static void formatMaps(ArrayList<FormatType> formats, JsonObject oldMap_) {
        JsonObject oldMap = oldMap_;
        for(FormatType type : formats) {
            if(oldMap.has(type.getExtension())) {
                if(!new Gson().fromJson(oldMap.get(type.getExtension()), new TypeToken<ArrayList<String>>(){}.getType()).equals(type.getConversionTypes())) {
                    JsonArray newConversionTypes = new JsonArray();
                    for(String format : type.getConversionTypes()) {
                        newConversionTypes.add(format);
                    }
                    oldMap.remove(type.getExtension());
                }
            }
        }
        Writers.writeFile(new File(DotConvert.installLocation + "\\formats\\file_map.json"), oldMap.toString());
    }
}
