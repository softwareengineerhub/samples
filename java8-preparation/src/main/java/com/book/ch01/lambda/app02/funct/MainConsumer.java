package com.book.ch01.lambda.app02.funct;

import java.util.function.*;

public class MainConsumer {

    public static void main(String[] args) {
        Consumer<String> c = (s) -> {
            System.out.println(s);
        };
        c.accept("Data");
        System.out.println("------------------------");
        Consumer<String> c2 = c.andThen(s -> System.out.println("After"));
        c2.accept("Test");
    }
}
