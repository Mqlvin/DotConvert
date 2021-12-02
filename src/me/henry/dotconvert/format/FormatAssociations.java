package me.henry.dotconvert.format;

import me.henry.dotconvert.registry.RegistryHandler;
import me.henry.dotconvert.registry.RegistryMethods;

import java.util.ArrayList;
import java.util.Arrays;

public class FormatAssociations {
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

    public static String getFormatIcon(String fileExtension) {
        ArrayList<String> classRootQuery = RegistryHandler.query("HKEY_CLASSES_ROOT\\" + getProgID(fileExtension) + "\\DefaultIcon");
        return RegistryMethods.parseString(classRootQuery.get(1)).data();
    }
}
