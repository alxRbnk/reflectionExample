package org.rbnk.reflection.main;

import org.rbnk.reflection.composite.Component;
import org.rbnk.reflection.parser.JsonParser;
import org.rbnk.reflection.reader.JsonFileReader;
import org.rbnk.reflection.reader.impl.JsonFileReaderImpl;

public class Main {
    public static void main(String[] args) {

        JsonFileReader reader = new JsonFileReaderImpl();
        String jsonContent = reader.readJsonFile("file2.json");
        JsonParser parser = new JsonParser();
        Component jsonObject = parser.parse(jsonContent);
        System.out.println(jsonContent);
    }
}