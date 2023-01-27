/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.app12.ch02.parallelstream.ch03;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;

/**
 *
 * @author dprokopiuk
 */
public class MainReduceAndAvg {
    
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        OptionalDouble avg = list.parallelStream()
                .sequential()
                .mapToDouble(i->i)
                .peek(i->{
                    System.out.println(i+": "+Thread.currentThread().getName());
                })
                .reduce((i,j)->(i+j)/2);
        
        avg.ifPresent(i->System.out.println("Avg of sequential stream with reduce: "+i));               
        
        avg = list.parallelStream()        
                .mapToDouble(i->i)
                .peek(i->{
                    System.out.println(i+": "+Thread.currentThread().getName());
                })
                .reduce((i,j)->(i+j)/2);
        
        avg.ifPresent(i->System.out.println("Avg of parallel stream with reduce: "+i));               
        
        avg = list.parallelStream()        
                .mapToDouble(i->i)
                .peek(i->{
                    System.out.println(i+": "+Thread.currentThread().getName());
                })
                .average();
        
        avg.ifPresent(i->System.out.println("Avg of parallel stream with AVG: "+i));               
                
        
    }
    
}
