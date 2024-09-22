package org.rbnk.reflection.reader.impl;

import org.rbnk.reflection.exception.CustomException;
import org.rbnk.reflection.reader.CustomReader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;


public class CustomReaderImpl implements CustomReader {

    @Override
    public String readJson(String path) throws CustomException {
        StringBuilder text = new StringBuilder();
        try {
            List<String> lines = Files.readAllLines(Paths.get(path));
            lines.stream()
                    .map(String::strip)
                    .forEach(text::append);
            return text.toString();
        } catch (IOException e) {
            throw new CustomException("Error reading file from path: ", e);
        }
    }
}
