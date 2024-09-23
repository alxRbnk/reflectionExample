package org.rbnk.reflection.composite;

import java.util.Map;

public class ComponentValue implements Component {

    private final String value;

    public ComponentValue(String value) {
        this.value = value;
    }

    @Override
    public String collect() {
        return value;
    }

    @Override
    public void add(Component component) {
        throw new UnsupportedOperationException("Cannot add to a leaf component");
    }

    @Override
    public void remove(Component component) {
        throw new UnsupportedOperationException("Cannot remove from a leaf component");
    }

    @Override
    public int count() {
        return 1;
    }

    @Override
    public Map<String, Component> getTextComponent() {
        return Map.of();
    }
}
