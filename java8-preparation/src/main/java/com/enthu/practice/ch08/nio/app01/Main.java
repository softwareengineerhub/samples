package com.enthu.practice.ch08.nio.app01;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) {
        Path path = Paths.get("T:\\..\\..\\.\\p2\\core");
        System.out.println("actual Path="+path);

        Path normilized = path.normalize();
        System.out.println("normalized="+normilized);
    }

}
