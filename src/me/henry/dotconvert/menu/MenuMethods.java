package me.henry.dotconvert.menu;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import me.henry.dotconvert.DotConvert;
import me.henry.dotconvert.formats.FormatAssociations;
import me.henry.dotconvert.io.Readers;
import me.henry.dotconvert.io.Writers;
import me.henry.dotconvert.registry.RegistryHandler;
import me.henry.dotconvert.registry.RegistryTypes;

import java.io.File;
import java.net.URLEncoder;
import java.util.WeakHashMap;

public class MenuMethods {
    public static void refreshExtension(String fileExtension) {
        JsonObject profile = createExtensionProfile(fileExtension);

        JsonObject extensionObject = new JsonParser().parse(Readers.readJson(new File(DotConvert.installLocation + "\\registry\\extensions.json"))).getAsJsonObject();
        if(extensionObject.has(fileExtension)) {
            extensionObject.remove(profile.get(fileExtension).toString().replace("\"", ""));
        }
        extensionObject.add(fileExtension, profile);
        Writers.writeFile(new File(DotConvert.installLocation + "\\registry\\extensions.json"), extensionObject.toString());

        createRegistryItems(profile, fileExtension);
    }

    private static JsonObject createExtensionProfile(String fileExtension) {
        String progID = FormatAssociations.getProgID(fileExtension);
        String iconLocation = URLEncoder.encode(FormatAssociations.getFormatIcon(fileExtension));

        JsonObject obj = new JsonObject();
        JsonObject elements = new JsonObject();
        elements.add("progID", new JsonParser().parse(progID));
        elements.add("iconLocation", new JsonParser().parse(iconLocation));
        obj.add(fileExtension, elements);
        return obj;
    }

    private static void createRegistryItems(JsonObject profile, String fileExtension) {
        String registryKey = "HKCR\\" + profile.get(fileExtension).getAsJsonObject().get("progID").toString().replace("\"", "") + "\\shell\\DotConvert";
        RegistryHandler.addKey( registryKey + "\\shell");
        RegistryHandler.addEntry(registryKey, "MUIVerb", "Convert to...", RegistryTypes.REG_SZ);
        RegistryHandler.addEntry(registryKey, "SubCommands", "", RegistryTypes.REG_SZ);

        
    }
}
