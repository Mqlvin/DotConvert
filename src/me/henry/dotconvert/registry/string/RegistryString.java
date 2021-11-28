package me.henry.dotconvert.registry.string;

public class RegistryString implements RegistryStringImpl {
    private String name;
    private String data;

    public RegistryString(String name, String data) {
        this.name = name;
        this.data = data;
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public String data() {
        return data;
    }
}
