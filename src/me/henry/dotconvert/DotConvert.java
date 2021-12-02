package me.henry.dotconvert;

import me.henry.dotconvert.format.FormatHandler;
import me.henry.dotconvert.install.Installer;
import me.henry.dotconvert.log.registry.RegistryLogger;
import me.henry.dotconvert.registry.tweaker.RegistryTweaker;

import java.io.File;

public class DotConvert {
    public static File installLocation = new File(System.getProperty("user.dir"));

    public static void main(String[] args) {
        // Init
        RegistryLogger.loadRegMods();

        // ---

        if(args.length == 0) {
            System.exit(-1);
        } else if(args[0].equalsIgnoreCase("install")) {
            Installer.install(installLocation.toString());
        } else if(args[0].equalsIgnoreCase("update")) {
            FormatHandler.loadFormats();
            RegistryTweaker.tweakAllFormats();
        } else if(args.length == 2 && args[0].equalsIgnoreCase("convert")) {
            System.out.println("Converting: " + args[1]);
            new Thread(() -> {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        } else if(args[0].equalsIgnoreCase("test-args")) {
            FormatHandler.loadFormats();
        }
        System.out.println("%root%: " + installLocation);


        // De-init
        RegistryLogger.saveRegMods();


        // ---

        // TODO: Fix .flac it's not working D:
        // Assoc.GrooveMusic
    }
}
