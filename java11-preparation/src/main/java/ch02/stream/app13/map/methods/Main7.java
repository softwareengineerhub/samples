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
public class Main7 {
    
    public static void main(String[] args) {
        Map map = new HashMap();
        map.put("a", 1);
        map.put("b", 2);
        map.put("c", 3);
        
        Object res = map.putIfAbsent("a", 10);
        
        
        System.out.println("res="+res);
        System.out.println("---------");
        System.out.println(map);
    }
    
}
