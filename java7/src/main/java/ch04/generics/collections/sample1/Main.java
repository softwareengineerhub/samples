/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch04.generics.collections.sample1;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

/**
 *
 * @author Denys.Prokopiuk
 */
public class Main {
    
    public static void main(String[] args) {
        new ArrayList<>();
        Deque<Integer> d = new ArrayDeque<>();
        d.push(1);
        d.push(2);
        d.push(3);
        System.out.println(d);
        System.out.println(d.remove());
        System.out.println(d.remove());
        System.out.println(d.remove());
        System.out.println("----------------");
        d = new ArrayDeque<>();
        d.add(1);
        d.add(2);
        d.addFirst(3);
        System.out.println(d);
        System.out.println(d.pollLast());
        System.out.println(d.pollLast());
        System.out.println(d.pollLast());
        
    }
    
}
