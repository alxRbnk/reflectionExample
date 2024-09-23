package org.rbnk.reflection.composite;

import java.util.Map;

public class ComponentValue implements Component {
    private final String value;

    public ComponentValue(String value) {
        this.value = value;
    }

    @Override
    public void add(Component component) {
    }

    @Override
    public void remove(Component component) {
    }

    @Override
    public int count() {
        return 1;
    }

    @Override
    public Map<String, Component> getTextComponent() {
        return Map.of();
    }

    @Override
    public String collect() {
        if (value.matches("-?\\d+(\\.\\d+)?")) {
            return value;
        } else {
            return "\"" + value + "\"";
        }
    }
}
