/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.enthu.practice.ch03.collections.app01;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author admin
 */
public class Main42 {
    
    
    
    
    public static void main(String[] args) {
        Set<String> set = new TreeSet();
        set.add("<23Bb>");
        set.add("<23bB>");
        set.add("<B23b>");
        set.add("<BB23>");
        set.add("<b23B>");
        set.add("<bB23>");
        set.add("<bb23>");
        
        for(String s: set){
            System.out.println("s="+s+";");
        }
    }
    
}
