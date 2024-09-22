package org.rbnk.reflection.main;

import org.rbnk.reflection.exception.CustomException;
import org.rbnk.reflection.deprecated.CustomParser;
import org.rbnk.reflection.deprecated.impl.CustomParserImpl;
import org.rbnk.reflection.reader.CustomReader;
import org.rbnk.reflection.reader.impl.CustomReaderImpl;

public class Main {
    public static void main(String[] args) throws CustomException {

        CustomReader reader = new CustomReaderImpl();
        CustomParser parser = new CustomParserImpl();
        String text = reader.readJson("src/main/resources/file2.json");
        parser.parseJson(text);






    }
}