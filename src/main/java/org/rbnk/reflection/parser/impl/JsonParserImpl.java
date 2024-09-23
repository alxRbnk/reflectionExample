package org.rbnk.reflection.parser.impl;

import org.rbnk.reflection.composite.Component;
import org.rbnk.reflection.composite.ComponentArray;
import org.rbnk.reflection.composite.ComponentObject;
import org.rbnk.reflection.composite.ComponentValue;
import org.rbnk.reflection.parser.JsonParser;

public class JsonParserImpl implements JsonParser {

    public ComponentObject parse(String json) {
        json = json.trim();
        return parseObject(json);
    }

    private ComponentObject parseObject(String json) {
        ComponentObject jsonObject = new ComponentObject();
        json = json.substring(1, json.length() - 1).trim();
        int level = 0;
        StringBuilder currentPair = new StringBuilder();
        for (int i = 0; i < json.length(); i++) {
            char c = json.charAt(i);
            if (c == '{' || c == '[') {
                level++;
            } else if (c == '}' || c == ']') {
                level--;
            }
            if (c == ',' && level == 0) {
                processKeyValue(jsonObject, currentPair.toString());
                currentPair.setLength(0);
            } else {
                currentPair.append(c);
            }
        }
        if (currentPair.length() > 0) {
            processKeyValue(jsonObject, currentPair.toString());
        }
        return jsonObject;
    }

    private void processKeyValue(ComponentObject jsonObject, String pair) {
        pair = pair.trim();
        int colonIndex = pair.indexOf(':');

        if (colonIndex == -1) {
            throw new IllegalArgumentException("Invalid key-value pair: " + pair);
        }
        String key = pair.substring(0, colonIndex).trim();
        String value = pair.substring(colonIndex + 1).trim();
        key = key.replaceAll("^\"|\"$", "");
        if (value.startsWith("[")) {
            Component arrayComponent = parseArray(value);
            jsonObject.add(key, arrayComponent);
        } else {
            Component valueComponent = parseValue(value);
            jsonObject.add(key, valueComponent);
        }
    }

    private Component parseArray(String json) {
        ComponentArray jsonArray = new ComponentArray();
        json = json.substring(1, json.length() - 1).trim();
        StringBuilder currentValue = new StringBuilder();
        int level = 0;
        for (int i = 0; i < json.length(); i++) {
            char c = json.charAt(i);
            if (c == '[' || c == '{') {
                level++;
            } else if (c == ']' || c == '}') {
                level--;
            }
            if (c == ',' && level == 0) {
                jsonArray.add(parseValue(currentValue.toString().trim()));
                currentValue.setLength(0);
            } else {
                currentValue.append(c);
            }
        }
        if (currentValue.length() > 0) {
            jsonArray.add(parseValue(currentValue.toString().trim()));
        }
        return jsonArray;
    }

    private Component parseValue(String value) {
        value = value.trim();
        if (value.startsWith("{")) {
            return parseObject(value);
        } else if (value.startsWith("[")) {
            return parseArray(value);
        } else if (value.startsWith("\"")) {
            return new ComponentValue(value.replaceAll("^\"|\"$", ""));
        } else if (isNumber(value)) {
            return new ComponentValue(value);
        } else {
            throw new IllegalArgumentException("Invalid JSON value: " + value);
        }
    }

    private boolean isNumber(String value) {
        try {
            Double.parseDouble(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
