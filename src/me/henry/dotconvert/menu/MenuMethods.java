package me.henry.dotconvert.menu;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import me.henry.dotconvert.formats.FormatAssociations;

import java.net.URLEncoder;

public class MenuMethods {
    public static JsonObject createExtensionProfile(String fileExtension) {
        String progID = FormatAssociations.getProgID(fileExtension);
        String iconLocation = URLEncoder.encode(FormatAssociations.getFormatIcon(fileExtension));

        JsonObject obj = new JsonObject();
        JsonObject elements = new JsonObject();
        elements.add("progID", new JsonParser().parse(progID));
        elements.add("iconLocation", new JsonParser().parse(iconLocation));
        obj.add(fileExtension, elements);
        return obj;
    }

    public static void refreshExtension(String fileExtension) {
        JsonObject profile = createExtensionProfile(fileExtension);

    }
}
