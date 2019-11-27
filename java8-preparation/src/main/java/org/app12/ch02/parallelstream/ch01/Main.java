/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.app12.ch02.parallelstream.ch01;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author dprokopiuk
 */
public class Main {
    
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        int res=list.stream()
                .parallel()
                //.sequential()
                .peek(i->{
                    System.out.println(i+": "+Thread.currentThread().getName());
                })
                .mapToInt(i->i)
                .sum();
        System.out.println("res="+res);
    }
    
}
