/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch04.generics.collections.sample4;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 *
 * @author Denys.Prokopiuk
 */
public class Main02 {
    
    public static void main(String[] args) {
        List<MyParent04> list = new ArrayList();
        check(list);
        list.add(new MyParent04());
        for(Object obj: list){
            System.out.println(obj);
        }
    }
    
    
    public static void check(List list){
        list.add("a");
    }
    
}
