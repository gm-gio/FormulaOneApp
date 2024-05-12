package com.meshveliani.giorgi.formuloneapp;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        Facade facade = new Facade();

        try {
            for (String formattedRacer : facade.processFormulaOneData("abbreviations.txt",
                    "start.log", "end.log")) {
                System.out.println(formattedRacer);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}