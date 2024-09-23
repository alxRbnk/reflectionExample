package org.rbnk.reflection.composite;

import java.util.HashMap;
import java.util.Map;

public class ComponentObject implements Component {
    private final Map<String, Component> components = new HashMap<>();

    public void add(String key, Component component) {
        components.put(key, component);
    }

    @Override
    public void add(Component component) {
    }

    @Override
    public void remove(Component component) {
        components.values().remove(component);
    }

    @Override
    public int count() {
        return components.size();
    }

    @Override
    public Map<String, Component> getTextComponent() {
        return components;
    }

    @Override
    public String collect() {
        StringBuilder json = new StringBuilder("{");
        for (Map.Entry<String, Component> entry : components.entrySet()) {
            json.append("\"").append(entry.getKey()).append("\": ")
                    .append(entry.getValue().collect()).append(", ");
        }
        if (json.length() > 1) {
            json.delete(json.length() - 2, json.length());
        }
        json.append("}");
        return json.toString();
    }
}
