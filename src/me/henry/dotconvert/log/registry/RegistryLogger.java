package me.henry.dotconvert.log.registry;

import me.henry.dotconvert.DotConvert;
import me.henry.dotconvert.io.Readers;
import me.henry.dotconvert.io.Writers;

import java.io.File;
import java.util.ArrayList;

public class RegistryLogger {
    public static ArrayList<String> actions = new ArrayList<>();

    public static void logAction() {

    }

    public static void loadRegMods() {
        actions = Readers.readArrayList(new File(DotConvert.installLocation + "\\tweaks.log"));
    }

    public static void saveRegMods() {
        Writers.writeFile(new File(DotConvert.installLocation + "\\tweaks.log"), actions);
    }
}
