package com.book.ch03.exceptions;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        List<Integer> data = list.stream().flatMap(item->{
           List<Integer> res = new ArrayList<>();
           res.add(Integer.parseInt(item));
           res.add(Integer.parseInt(item)*10);
           return res.stream();
        }).collect(Collectors.toList());
        System.out.println("-----------");
        System.out.println(data);
    }

}
