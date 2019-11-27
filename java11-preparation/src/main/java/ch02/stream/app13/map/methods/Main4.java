/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch02.stream.app13.map.methods;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 *
 * @author asusadmin
 */
public class Main4 {
    
    public static void main(String[] args) {
        Map map = new HashMap();
        map.put("a", 1);
        map.put("b", 2);
        map.put("c", 3);
        
        map.forEach(new BiConsumer() {
            @Override
            public void accept(Object t, Object u) {
                System.out.println(t+"="+u);
            }
        });
        
    }
    
}
