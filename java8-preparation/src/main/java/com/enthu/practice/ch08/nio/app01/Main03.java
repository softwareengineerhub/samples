package com.enthu.practice.ch08.nio.app01;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Main03 {

    public static void main(String[] args) {
        Path path = Paths.get("c:\\personal\\.\\photos\\..\\readme.txt");
        System.out.println("actual Path="+path);
///
        Path normilized = path.normalize();
        System.out.println("normalized="+normilized);
    }

}
