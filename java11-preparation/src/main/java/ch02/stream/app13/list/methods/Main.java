/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch02.stream.app13.list.methods;

import java.util.ArrayList;
import java.util.List;
import java.util.function.UnaryOperator;

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
        list.replaceAll(new UnaryOperator() {
            @Override
            public Object apply(Object t) {
                return t+";update";
            }
        });
        System.out.println(list);
    }
    
}
