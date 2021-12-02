package me.henry.dotconvert.log.registry;

import me.henry.dotconvert.DotConvert;
import me.henry.dotconvert.io.Readers;
import me.henry.dotconvert.io.Writers;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class RegistryLogger {
    public static ArrayList<String> actions = new ArrayList<>();

    public static void logAction(String action) {
        actions.add("[" + new SimpleDateFormat("HH:mm:ss").format(new Date()) + "] " + action);
    }

    public static void loadRegMods() {
        actions = Readers.readArrayList(new File(DotConvert.installLocation + "\\registry\\tweaks.log"));
    }

    public static void saveRegMods() {
        Writers.writeFile(new File(DotConvert.installLocation + "\\registry\\tweaks.log"), actions);
    }
}
