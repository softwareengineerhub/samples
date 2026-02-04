package org.example.generics;

import java.util.ArrayList;
import java.util.List;

public class MyGeneric {

    public static void main(String[] args) {
        List<Parent> list = new ArrayList();
        //list.add(new Parent());
        //list.add(new Child());
        producer(list);
        System.out.println(list);
    }

    public static void producer(List<? super Parent> list){
        list.add(new Parent());
        list.add(new Child());
        //Parent p = list.get(0);
        //Child p = list.get(0);
        Object p = list.get(0);
        //list.add(new Object());
    }

    public static void consumer(List<? extends Parent> list){
        //list.add(new Parent());
        //list.add(new Child());
        Parent p = list.get(0);
        //Child ch = list.get(0);
        //list.add(new Object());
        list.add(null);
    }

    public static void test(List<?> list){
        //list.add(new Parent());
        //list.add(new Child());
        Object p = list.get(0);
        //Child ch = list.get(0);
        //list.add(new Object());
        list.add(null);
    }

}
