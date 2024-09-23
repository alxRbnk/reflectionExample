package org.rbnk.reflection.main;

import org.rbnk.reflection.composite.Component;
import org.rbnk.reflection.parser.impl.JsonParserImpl;
import org.rbnk.reflection.reader.JsonFileReader;
import org.rbnk.reflection.reader.impl.JsonFileReaderImpl;

public class Main {
    public static void main(String[] args) {

        JsonFileReader reader = new JsonFileReaderImpl();
        String jsonContent = reader.readJsonFile("file2.json");
        JsonParserImpl parser = new JsonParserImpl();
        Component jsonObject = parser.parse(jsonContent);
        System.out.println(jsonContent);
    }
}