package me.henry.dotconvert.menu;

public class MenuMethods {
    /*
    public static void refreshExtension(String fileExtension) {
        JsonObject profile = createExtensionProfile(fileExtension);

        JsonObject extensionObject = new JsonParser().parse(Readers.readJson(new File(DotConvert.installLocation + "\\registry\\extensions.json"))).getAsJsonObject();
        if(extensionObject.has(fileExtension)) {
            extensionObject.remove(profile.get(fileExtension).toString().replace("\"", ""));
        }
        extensionObject.add(fileExtension, profile);
        Writers.writeFile(new File(DotConvert.installLocation + "\\registry\\extensions.json"), extensionObject.toString());

        createRegistryItems(profile, fileExtension);
    }

    private static JsonObject createExtensionProfile(String fileExtension) {
        String progID = FormatAssociations.getProgID(fileExtension);
        String iconLocation = URLEncoder.encode(FormatAssociations.getFormatIcon(fileExtension));

        JsonObject obj = new JsonObject();
        JsonObject elements = new JsonObject();
        elements.add("progID", new JsonParser().parse(progID));
        elements.add("iconLocation", new JsonParser().parse(iconLocation));
        obj.add(fileExtension, elements);
        return obj;
    }

    private static void createRegistryItems(JsonObject profile, String fileExtension) {
        String registryKey = "HKCR\\" + profile.get(fileExtension).getAsJsonObject().get("progID").toString().replace("\"", "") + "\\shell\\DotConvert";
        RegistryHandler.addKey( registryKey + "\\shell");
        RegistryHandler.addEntry(registryKey, "MUIVerb", "Convert to...", RegistryTypes.REG_SZ, false);
        RegistryHandler.addEntry(registryKey, "SubCommands", "", RegistryTypes.REG_SZ, false);

        
    }
     */
}
