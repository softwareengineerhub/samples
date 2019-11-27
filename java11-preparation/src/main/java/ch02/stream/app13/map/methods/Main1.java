/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch02.stream.app13.map.methods;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

/**
 *
 * @author asusadmin
 */
public class Main1 {
    
    public static void main(String[] args) {
        Map map = new HashMap();
        map.put("a", 1);
        Object result = map.compute("a2", new BiFunction() {
            @Override
            public Object apply(Object t, Object u) {
                return "1111";//t+";"+u;
            }
        });
        System.out.println("map="+map);
        System.out.println("result="+result);
    }
    
}
