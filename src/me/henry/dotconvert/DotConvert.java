package me.henry.dotconvert;

import me.henry.dotconvert.format.FormatHandler;
import me.henry.dotconvert.install.Installer;
import me.henry.dotconvert.registry.tweaker.RegistryTweaker;

import java.io.File;

public class DotConvert {
    public static File installLocation = new File(System.getProperty("user.dir"));

    public static void main(String[] args) {
        if(args.length == 0) {
            System.exit(-1);
        } else if(args[0].equalsIgnoreCase("install")) {
            Installer.install(installLocation.toString());
        } else if(args[0].equalsIgnoreCase("update")) {
            FormatHandler.loadFormats();
            RegistryTweaker.tweakFormat(FormatHandler.getObjectFromExtension("mp3"));
        } else if(args.length == 2 && args[0].equalsIgnoreCase("convert")) {
            FormatHandler.loadFormats();
        } else if(args[0].equalsIgnoreCase("test-args")) {
            FormatHandler.loadFormats();
        }
        System.out.println("%root%: " + installLocation);
    }
}
