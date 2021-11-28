package me.henry.dotconvert;

import me.henry.dotconvert.install.Installer;
import me.henry.dotconvert.registry.RegistryHandler;
import me.henry.dotconvert.registry.RegistryTypes;

import java.io.File;

public class DotConvert {
    public static File installLocation = new File(System.getProperty("user.dir"));

    public static void main(String[] args) {
        if(args.length == 0) {
            System.exit(-1);
        } else if(args[0].equalsIgnoreCase("install")) {
            Installer.install(installLocation.toString());
        }

        RegistryHandler.addKey("HKCR\\jpegfile\\shell\\dotconvert\\shell");
        RegistryHandler.addEntry("HKCR\\jpegfile\\shell\\dotconvert", "MUIVerb", "Convert to...", RegistryTypes.REG_SZ);
    }
}
