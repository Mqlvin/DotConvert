package me.henry.dotconvert.formats;

import me.henry.dotconvert.registry.RegistryMethods;
import me.henry.dotconvert.registry.RegistryHandler;

import java.util.ArrayList;
import java.util.Arrays;

public class FormatAssociations {
    public static String getFormatIcon(String fileExtension) {
        ArrayList<String> classRootQuery = RegistryHandler.query("HKEY_CLASSES_ROOT\\" + getProgID(fileExtension) + "\\DefaultIcon");
        ArrayList<String> registryData = new ArrayList<>(Arrays.asList((RegistryMethods.parseString(classRootQuery.get(1)).data().split("exe")[0] + "exe").toString().split("")));
        while(!(registryData.get(1) + registryData.get(2)).equalsIgnoreCase(":\\")) {
            registryData.remove(0);
        }
        StringBuilder builder = new StringBuilder();
        for(String character : registryData) {
            builder.append(character);
        }
        return builder.toString();
    }

    public static String getProgID(String fileExtension) {
        ArrayList<String> extensionInfo = RegistryHandler.query("HKEY_CLASSES_ROOT\\." + fileExtension);
        for(String item : extensionInfo) {
            if(item.replace(" ", "").startsWith("(Default)")) {
                String[] parser = item.split(" ");
                return parser[parser.length - 1];
            }
        }
        return null;
    }
}
