package org.rbnk.reflection.composite;

import java.util.Map;

public interface Component {
    String collect();

    void add(Component component);

    void remove(Component component);

    int count();

    Map<String, Component> getTextComponent();
}
