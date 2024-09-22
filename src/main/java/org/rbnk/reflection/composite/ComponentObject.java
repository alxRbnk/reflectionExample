package org.rbnk.reflection.composite;

import java.util.HashMap;
import java.util.Map;

public class ComponentObject implements Component {
    private String type;
    private Map<String, Component> components = new HashMap<>();

    public ComponentObject(String type){
        this.type = type;
    }

    public String collect(Component component) {
        return null;
    }

    public void add(Component component) {
        components.put(type, component);
    }

    public void remove(Component component) {
        components.remove(component);
    }

    public int count() {
        return components.size();
    }

    public Map<String, Component> getTextComponent() {
        return components;
    }

    public String getType() {
        return type;
    }
}
