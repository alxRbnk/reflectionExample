package org.rbnk.reflection.parser;

import org.rbnk.reflection.composite.ComponentObject;

public interface JsonParser {

    ComponentObject parse(String json);
}
