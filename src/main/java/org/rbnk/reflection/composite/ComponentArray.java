package org.rbnk.reflection.composite;

import java.util.Map;

public class ComponentArray implements Component{

    public String collect(Component component) {
        return null;
    }

    public void add(Component component) {
    }

    public void remove(Component component) {
    }

    public int count() {
        return 1;
    }

    public Map<String, Component> getTextComponent() {
        return Map.of();
    }
}
