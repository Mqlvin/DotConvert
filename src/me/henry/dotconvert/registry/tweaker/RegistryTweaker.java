package me.henry.dotconvert.registry.tweaker;

import me.henry.dotconvert.DotConvert;
import me.henry.dotconvert.format.FormatHandler;
import me.henry.dotconvert.format.type.FormatObject;
import me.henry.dotconvert.log.registry.RegistryLogger;
import me.henry.dotconvert.registry.RegistryHandler;
import me.henry.dotconvert.registry.RegistryTypes;

public class RegistryTweaker {
    public static void tweakFormat(FormatObject formatType) {
        if(formatType == null) {
            return;
        }

        String workingDir = "HKCR\\" + formatType.getProgID() + "\\shell\\DotConvert";
        RegistryHandler.addKey(workingDir);
        RegistryLogger.logAction("key:created:" + workingDir);
        RegistryHandler.addEntry(workingDir, "MUIVerb", "Convert to...", RegistryTypes.REG_SZ, true);
        RegistryLogger.logAction("entry:created:" + workingDir + ":MUIVerb:Convert to...:REG_SZ");
        RegistryHandler.addEntry(workingDir, "Icon", formatType.getIcoPath().replace("\"", "\\\"").substring(1), RegistryTypes.REG_SZ, true);
        RegistryLogger.logAction("entry:created:" + workingDir + ":Icon:" + formatType.getIcoPath().replace("\"", "\\\"").substring(1) + ":REG_SZ");
        RegistryHandler.addEntry(workingDir, "Subcommands", "", RegistryTypes.REG_SZ, true);
        RegistryLogger.logAction("entry:created:" + workingDir + ":Subcommands::REG_SZ");

        RegistryHandler.addKey(workingDir + "\\shell");
        RegistryLogger.logAction("key:created:" + workingDir + "\\shell");
        for(FormatObject format : FormatHandler.formats) {
            if(formatType.getConversionsList().contains(format.getExtension())) {
                RegistryHandler.addKey(workingDir + "\\shell\\" + format.getExtension().toLowerCase() + "...\\command");
                RegistryLogger.logAction("key:created:" + workingDir + "\\shell\\" + format.getExtension().toLowerCase() + "...\\command");
                RegistryHandler.addEntry(workingDir + "\\shell\\" + format.getExtension().toLowerCase() + "...", "Icon", format.getIcoPath().replace("\"", "\\\"").substring(1), RegistryTypes.REG_SZ, true);
                RegistryLogger.logAction("entry:created:" + workingDir + "\\shell\\" + format.getExtension().toLowerCase() + "..." + ":Icon:" + format.getIcoPath().replace("\"", "\\\"").substring(1) + ":REG_SZ");
                RegistryHandler.setDefault(workingDir + "\\shell\\" + format.getExtension().toLowerCase() + "...\\command", ("cmd /c /q \"java -jar " + DotConvert.installLocation + "\\DotConvert.jar convert \"\"\"%0\"\"").replace("\"", "\\\""));
                RegistryLogger.logAction("entry:created:" + workingDir + "\\shell\\" + format.getExtension().toLowerCase() + "...\\command" + ":(Default):" + ("cmd /c /q \"java -jar " + DotConvert.installLocation + "\\DotConvert.jar convert \"\"\"%0\"\"").replace("\"", "\\\"") + ":REG_SZ");
            }
        }
    }

    public static void tweakAllFormats() {
        for(FormatObject format : FormatHandler.formats) {
            tweakFormat(format);
        }
    }
}
