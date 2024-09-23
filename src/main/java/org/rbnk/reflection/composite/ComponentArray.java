package org.rbnk.reflection.composite;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ComponentArray implements Component {
    private final List<Component> components = new ArrayList<>();

    @Override
    public void add(Component component) {
        components.add(component);
    }

    @Override
    public void remove(Component component) {
        components.remove(component);
    }

    @Override
    public int count() {
        return components.size();
    }

    @Override
    public Map<String, Component> getTextComponent() {
        return Map.of();
    }

    @Override
    public String collect() {
        StringBuilder json = new StringBuilder("[");
        for (Component component : components) {
            json.append(component.collect()).append(", ");
        }
        if (json.length() > 1) {
            json.delete(json.length() - 2, json.length());
        }
        json.append("]");
        return json.toString();
    }
}
