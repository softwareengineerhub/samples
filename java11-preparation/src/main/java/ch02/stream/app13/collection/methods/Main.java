/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch02.stream.app13.collection.methods;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 *
 * @author asusadmin
 */
public class Main {

    public static void main(String[] args) {
        List list = new ArrayList();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("A");
        list.add("B");
        boolean res = list.removeIf(new Predicate() {
            @Override
            public boolean test(Object t) {
                System.out.println("predicate");
                return "A".equals(t) || "B".equals(t);
            }
        });
        System.out.println("res="+res);
        System.out.println(list);
    }
    
}
