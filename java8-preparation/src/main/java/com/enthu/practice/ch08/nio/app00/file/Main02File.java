package com.enthu.practice.ch08.nio.app00.file;

import java.io.File;
import java.io.IOException;

public class Main02File {

    public static void main(String[] args) throws IOException {
        File file = new File("mydir/test/www");
        boolean res = file.mkdirs();
        System.out.println("res="+res);
    }
}
