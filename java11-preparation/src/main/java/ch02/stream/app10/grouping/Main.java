/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch02.stream.app10.grouping;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * @author asusadmin
 */
public class Main {

    public static void main(String[] args) {
        MyPhone p1 = new MyPhone(1, "Name1");
        MyPhone p2 = new MyPhone(2, "Name2");
        MyPhone p3 = new MyPhone(3, "Name3");
        MyPhone p4 = new MyPhone(4, "Name4");
        MyPhone p5 = new MyPhone(1, "Name5");
        Map<Integer, List<MyPhone>> map = Stream.of(p1, p2, p3, p4, p5).collect(Collectors.groupingBy(new Function<MyPhone, Integer>() {

            @Override
            public Integer apply(MyPhone t) {
                return t.getId();
            }

        }));
        System.out.println(map.getClass());
        for (int key : map.keySet()) {
            System.out.println(key + "=" + map.get(key) + "; " + map.get(key).getClass());
        }
        System.out.println("-------------------------------------------------------------------");

        Map<Integer, List<MyPhone>> map2 = Stream.of(p1, p2, p3, p4, p5).collect(Collectors.groupingBy(MyPhone::getId));
        System.out.println(map2.getClass());
        for (int key : map2.keySet()) {
            System.out.println(key + "=" + map2.get(key));
        }
        System.out.println("-------------------------------------------------------------------");

        Map<Integer, Set<MyPhone>> map3 = Stream.of(p1, p2, p3, p4, p5).collect(Collectors.groupingBy(MyPhone::getId, Collectors.toSet()));
        System.out.println(map2.getClass());
        for (int key : map3.keySet()) {
            System.out.println(key + "=" + map3.get(key) + "; " + map3.get(key).getClass());
        }
        System.out.println("-------------------------------------------------------------------");

        Map<Boolean, List<MyPhone>> map4 = Stream.of(p1, p2, p3, p4, p5).collect(Collectors.partitioningBy(new Predicate<MyPhone>() {

            @Override
            public boolean test(MyPhone t) {
                return (t.getId() + 2) % 2 == 0;
            }

        }));
        System.out.println(map4.getClass());
        for (boolean key : map4.keySet()) {
            System.out.println(key + "=" + map4.get(key) + "; " + map4.get(key).getClass());
        }
        System.out.println("-------------------------------------------------------------------");

        Map<Boolean, List<MyPhone>> map5 = Stream.of(p1, p2, p3, p4, p5).collect(Collectors.partitioningBy(t -> (t.getId() + 2) % 2 == 0));
        System.out.println(map5.getClass());
        for (boolean key : map5.keySet()) {
            System.out.println(key + "=" + map5.get(key) + "; " + map5.get(key).getClass());
        }
        System.out.println("-------------------------------------------------------------------");
    }

}
