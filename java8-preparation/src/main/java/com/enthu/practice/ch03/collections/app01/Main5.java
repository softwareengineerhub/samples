/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.enthu.practice.ch03.collections.app01;

import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 *
 * @author admin
 */
public class Main5 {
    
    public static void main(String[] args) {
        TreeSet<Integer> set = new TreeSet();
        for(int i=0;i<10;i+=2){
            set.add(i);
        }
        System.out.println(set);
        SortedSet<Integer> data = set.headSet(5);
        System.out.println(data);
        SortedSet<Integer> data2 = set.tailSet(5);
        System.out.println(data2);
        
        int lower = set.lower(5);
        int higher = set.higher(5);
        System.out.println("lower="+lower);
        System.out.println("higher="+higher);
        
        set.add(1);
        System.out.println("data="+data);
        System.out.println("set="+set);
    }
    
}
