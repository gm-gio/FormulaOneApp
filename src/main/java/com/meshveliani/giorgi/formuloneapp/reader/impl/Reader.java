package com.meshveliani.giorgi.formuloneapp.reader.impl;

import com.meshveliani.giorgi.formuloneapp.reader.AppReader;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Reader implements AppReader {
    private BufferedReader bufferedReader;

    public Reader() {
    }

    public Reader(BufferedReader bufferedReader) {
        this.bufferedReader = bufferedReader;
    }

    @Override
    public List<String> readFile(String resourceName) throws IOException {
        List<String> lines = new ArrayList<>();

        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(resourceName)) {
            assert inputStream != null;
            try (InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                 BufferedReader buffReader = new BufferedReader(inputStreamReader)) {

                String line;
                while ((line = buffReader.readLine()) != null) {
                    lines.add(line);
                }
            }
        }

        return lines;
    }
}


