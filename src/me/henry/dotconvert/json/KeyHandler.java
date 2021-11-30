package me.henry.dotconvert.json;

import com.google.gson.JsonObject;

import java.util.ArrayList;

public class KeyHandler {
    public static ArrayList<String> getAllProperties(JsonObject object) {
        if(object == null) {
            return null;
        }
        if(object.keySet().size() != 0) {
            return new ArrayList<>(object.keySet());
        }
        return null;
    }
}
