package org.rbnk.reflection.composite;

import java.util.HashMap;
import java.util.Map;

public class ComponentObject implements Component {
    private final String type;
    private final Map<String, Component> components = new HashMap<>();

    public ComponentObject(String type) {
        this.type = type;
    }

    @Override
    public String collect() {
        StringBuilder collectedText = new StringBuilder(type + ": {");
        components.forEach((key, component) -> collectedText.append("\n  ")
                .append(key)
                .append(": ")
                .append(component.collect()));
        collectedText.append("\n}");
        return collectedText.toString();
    }

    @Override
    public void add(Component component) {
        components.put(component.getTextComponent()
                .keySet().stream()
                .findFirst()
                .orElse("unknown"), component);
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

    public String getType() {
        return type;
    }
}
