package com.book.ch01.lambda.app03.optional;

import java.util.*;
import java.util.function.Function;
import java.util.function.Supplier;

public class Main {

    public static void main(String[] args) {
        Optional.of("A").flatMap(item->Optional.of(item.length()));

        Map<String, String> map = new HashMap<>();
        map.put("a", "A");
        map.put("b", "B");




    }

}
