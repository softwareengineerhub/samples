package com.enthu.practice.ch08.nio.app00.file;

import java.io.File;
import java.io.IOException;

public class Main01File {

    public static void main(String[] args) throws IOException {
        File file = new File("qqq.txt");
        boolean res = file.createNewFile();
        System.out.println("res="+res);

    }
}
