package me.henry.dotconvert.registry;

import me.henry.dotconvert.registry.string.RegistryString;

import java.util.ArrayList;
import java.util.Arrays;

public class RegistryMethods {
    public static RegistryString parseString(String key) {
        ArrayList<String> parser = new ArrayList<>(Arrays.asList(key.split("   ")));
        ArrayList<String> mirror = new ArrayList<>(parser); // To avoid ConcurrentModificationException
        for(String item : mirror) {
            if(item.equalsIgnoreCase("")) {
                parser.remove(item);
            }
        }
        return new RegistryString(parser.get(0), parser.get(2));
    }
}
