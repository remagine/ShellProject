package com.shell;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String path = "/Users/pololo/test";
        List<String> fileNames1 = List.of(path + "/test1.txt");
        List<String> fileNames2 = List.of(path + "/test1.txt", path + "/test2.txt");
        List<String> fileNames3 = List.of(path + "/test1.txt", path + "/test2.txt", path + "/test3.txt");
        List<String> fileNames4 = List.of(path + "/test1.txt", path + "/test2.txt", path + "/test3.txt" , path + "/test4.txt");
        List<String> fileNames5 = List.of(path + "/test1.txt", path + "/test4.txt", path + "/test3.txt");

        Cat cat = new Cat();
        cat.execute(fileNames5);

    }
}
