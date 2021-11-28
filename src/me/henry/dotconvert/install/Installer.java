package me.henry.dotconvert.install;

import me.henry.dotconvert.io.Writers;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class Installer {
    public static SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");

    public static Integer install(String location) {
        File rootDir = new File(location);
        if(rootDir.list().length != 1 && Arrays.asList(rootDir.list()).contains("DotConvert.jar")) {
            addInstallLog("DotConvert is already installed.");
            return 1; // Already installed
        }
        addInstallLog("Installation starting at " + location);

        /*
        ---> Start folders
         */
        File registryDir = new File(rootDir + "\\registry");
        if(registryDir.mkdir()) {
            addInstallLog("Created the \"%root%\\registry\" folder.");
        } else {
            addInstallLog("Unable to create \"%root%\\registry\" folder, aborting!");
        }


        /*
        ---> End folders
         */

        /*
        ---> Start files
         */
        File registryModsLoc = new File(rootDir + "\\registry\\extensions.json");
        createFile(registryModsLoc, "{}");

        /*
        ---> End files
         */


        return 0; // Success
    }

    public static void addInstallLog(String action) {
        String formatted = "[" + sdf.format(new Date()) + "] " + action;
        System.out.println(formatted);
    }

    public static void createFile(File location, String data) {
        if(location.exists()) {
            addInstallLog("Unable to create \"" + location + "\" as it already exists.");
            return;
        }
        try {
            Writers.writeFile(location, data);
            addInstallLog("Created the file \"" + location + "\"");
        } catch(Exception e) {
            addInstallLog(e.toString());
        }
    }
}
