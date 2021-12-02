package me.henry.dotconvert.registry.tweaker;

import me.henry.dotconvert.DotConvert;
import me.henry.dotconvert.format.FormatHandler;
import me.henry.dotconvert.format.type.FormatObject;
import me.henry.dotconvert.registry.RegistryHandler;
import me.henry.dotconvert.registry.RegistryTypes;

public class RegistryTweaker {
    public static void tweakFormat(FormatObject formatType) {
        if(formatType == null) {
            return;
        }

        String workingDir = "HKCR\\" + formatType.getProgID() + "\\shell\\DotConvert";
        RegistryHandler.addKey(workingDir);
        RegistryHandler.addEntry(workingDir, "MUIVerb", "Convert to...", RegistryTypes.REG_SZ, true);
        RegistryHandler.addEntry(workingDir, "Icon", formatType.getIcoPath().replace("\"", "\\\"").substring(1), RegistryTypes.REG_SZ, true);
        RegistryHandler.addEntry(workingDir, "Subcommands", "", RegistryTypes.REG_SZ, true);

        RegistryHandler.addKey(workingDir + "\\shell");
        for(FormatObject format : FormatHandler.formats) {
            if(formatType.getConversionsList().contains(format.getExtension())) {
                RegistryHandler.addKey(workingDir + "\\shell\\" + format.getExtension().toLowerCase() + "...\\command");
                RegistryHandler.addEntry(workingDir + "\\shell\\" + format.getExtension().toLowerCase() + "...", "Icon", format.getIcoPath().replace("\"", "\\\"").substring(1), RegistryTypes.REG_SZ, true);
                RegistryHandler.removeEntry(workingDir + "\\shell\\" + format.getExtension().toLowerCase() + "...\\command", "(Default)");
                RegistryHandler.addEntry(workingDir + "\\shell\\" + format.getExtension().toLowerCase() + "...\\command", "(Default)", ("cmd /c \"java -jar " + DotConvert.installLocation + "\\DotConvert.jar convert \"\"\"%0\"\"").replace("\"", "\\\""), RegistryTypes.REG_SZ, true);
            }
        }
    }
}
