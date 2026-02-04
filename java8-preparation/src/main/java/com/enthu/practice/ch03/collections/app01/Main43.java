/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.enthu.practice.ch03.collections.app01;

import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 *
 * @author admin
 */
public class Main43 {
    
    
    
    
    public static void main(String[] args) {
        Set<String> set = new TreeSet();
        set.add("< f>");
        set.add("<1f>");
        set.add("<2f>");
        set.add("<F>");
        set.add("<FF>");
        set.add("<f>");
        set.add("<ff>");
        set.add("<1234>");
        
        for(String s: set){
            System.out.println("s="+s+";");
        }  
       
    }
    
}
