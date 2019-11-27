/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch02.stream.app13.map.methods;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;

/**
 *
 * @author asusadmin
 */
public class Main3 {

    public static void main(String[] args) {
        Map map = new HashMap();
        map.put("c", 1);
        
        Object result = map.computeIfAbsent("c", new Function() {
         
            @Override
            public Object apply(Object t) {
                System.out.println("@@@@@Function");
                return t+"; an somevalue";
            }
        });        
        
        System.out.println("map=" + map);
        System.out.println("result=" + result);
    }

}
