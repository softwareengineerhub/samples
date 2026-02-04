package com.enthu.practice.ch08.nio.app01;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Main04 {

    public static void main(String[] args) {
        Path p1 = Paths.get("x\\y");
        Path p2 = Paths.get("z");
        Path res = p1.relativize(p2);
        System.out.println("res="+res);
    }

}
