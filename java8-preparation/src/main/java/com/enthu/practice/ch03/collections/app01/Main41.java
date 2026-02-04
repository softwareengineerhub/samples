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
public class Main41 {
    
    
    
    
    public static void main(String[] args) {
        Set<String> set = new TreeSet();
        set.add("<A>");
        set.add("<AA>");
        set.add("<a>");
        set.add("<aa>");
        set.add("<b>");
        set.add("<bb>");
        set.add("<c>");
        set.add("<cc>");
        set.add("<B>");
        set.add("<BB>");
        
        for(String s: set){
            System.out.println("s="+s+";");
        }
    }
    
}
