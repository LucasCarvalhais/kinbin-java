package com.kinbin.kinbin.loader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TransitionParser {
    private List<String> columnHeaders;

    public void parseColumnHeaders(String line) {
        columnHeaders = Arrays.asList(line.split(","));
    }

    public List<String> getColumnsHeaders() {
        return columnHeaders;
    }
}
