/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.app12.ch00.concurrent.collections.copyonwritelist;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 *
 * @author dprokopiuk
 */
public class Main {
    
    public static void main(String[] args) {
        //List<Integer> list = new ArrayList<>();
        List<Integer> list = new CopyOnWriteArrayList<>();
        list.add(0);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        
        
        Iterator<Integer> itr = list.iterator();
        while(itr.hasNext()){
            int n = itr.next();
            System.out.println(n);
            if(n==5){
                itr.remove();
            }
        }
                
        System.out.println(list);
        
    }
    
}
