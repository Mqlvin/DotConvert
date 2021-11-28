package me.henry.dotconvert.io;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Readers {
    public static String readJson(File path) {
        if(path.exists()) {
            try {
                ArrayList<String> textFromFile = new ArrayList<>(Files.readAllLines(Paths.get(path.toString())));
                return String.join("", textFromFile);
            } catch(Exception e) {
                System.out.println("Error: " + e);
            }
        }
        return null;
    }

    public static ArrayList<String> readArrayList(File path) {
        if(path.exists()) {
            try {
                ArrayList<String> textFromFile = new ArrayList<>(Files.readAllLines(Paths.get(path.toString())));
                return textFromFile;
            } catch(Exception e) {
                System.out.println("Error: " + e);
            }
        }
        return null;
    }
}
