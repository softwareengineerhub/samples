package com.book.ch01.lambda.app01.fi;

import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        Stream.of("1","2","3","4","5","6","7").map(item->item.toUpperCase()).forEach(System.out::println);
        System.out.println("--------------------------");
        Stream.of("1","2","3","4","5","6","7").map(String::toUpperCase).forEach(System.out::println);
    }

}
