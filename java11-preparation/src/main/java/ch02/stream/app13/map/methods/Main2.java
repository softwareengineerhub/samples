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
public class Main2 {
    
    public static void main(String[] args) {
        Map map = new HashMap();
        map.put("b", 1);
        Object result = map.computeIfPresent("a", new BiFunction() {
            @Override
            public Object apply(Object t, Object u) {
                System.out.println("@@@@BuFunction");
                return t+";"+u;
            }
        });
        System.out.println("map="+map);
        System.out.println("result="+result);
    }
    
}
