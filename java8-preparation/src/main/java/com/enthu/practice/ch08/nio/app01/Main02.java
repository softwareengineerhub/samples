package com.enthu.practice.ch08.nio.app01;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Main02 {

    public static void main(String[] args) {
        Path path = Paths.get("\\.\\.\\core\\file\\binary.java");
        System.out.println("actual Path="+path);
///c:\\personal\\.\\photos\\..\\readme.txt
        Path normilized = path.normalize();
        System.out.println("normalized="+normilized);
    }

}
