package com.enthu.practice.ch08.nio.app00.file;

import java.io.File;
import java.io.IOException;

public class Main03File {

    public static void main(String[] args) throws IOException {
        File file = new File("mydir");
        boolean res = file.mkdir();
        System.out.println("res="+res);
    }
}
