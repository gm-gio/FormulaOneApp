package com.meshveliani.giorgi.formuloneapp.reader;

import java.io.IOException;
import java.util.List;

public interface AppReader {
    List<String> readFile(String resourceName) throws IOException;
}
