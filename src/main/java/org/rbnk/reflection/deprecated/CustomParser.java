package org.rbnk.reflection.deprecated;

import java.util.Map;

public interface CustomParser {

    Map<String, Object> parseJson(String text);
}
