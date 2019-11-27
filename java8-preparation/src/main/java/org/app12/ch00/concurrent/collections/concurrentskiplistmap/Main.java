/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.app12.ch00.concurrent.collections.concurrentskiplistmap;

import java.util.concurrent.ConcurrentSkipListMap;

/**
 *
 * @author dprokopiuk
 */
public class Main {
    
    public static void main(String[] args) {
        ConcurrentSkipListMap map = new ConcurrentSkipListMap();
        map.put("c", -10);
        map.put("a", 10);
        map.put("b", 0);
        
        
       map.forEach((k,v)->{System.out.println(k+"="+v);});
    }
    
}
