package org.example.reduce;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BinaryOperator;

public class Main {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        int res = list.stream().map(i->i*2).reduce(new BinaryOperator<Integer>() {
            @Override
            public Integer apply(Integer a, Integer b) {
                return a+b;
            }
        }).get();
        System.out.println("res="+res);
    }

}
