package org.rbnk.reflection.reader;

import org.rbnk.reflection.exception.CustomException;

import java.util.List;

public interface CustomReader {

    String readJson(String path) throws CustomException;
}
