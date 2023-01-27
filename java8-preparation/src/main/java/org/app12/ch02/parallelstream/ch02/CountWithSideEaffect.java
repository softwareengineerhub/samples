/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.app12.ch02.parallelstream.ch02;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

/**
 *
 * @author dprokopiuk
 */
public class CountWithSideEaffect {
    
    
    public static void main(String[] args) {
        final MyCounter myCounter = new MyCounter();        
        int res=IntStream.range(0, 5000)
                .parallel()
                .filter(i->{
                    if(i%10==0){
                        myCounter.counter++;
                        return true;
                    }
                    return false;
                })                
                .sum();
        System.out.println("sum: "+res+", counter="+myCounter.counter);
        
        myCounter.counter=0;
        System.out.println("----------------------------------------");
                
        res=IntStream.range(0, 5000)
                .parallel()
                .filter(i->{
                    if(i%10==0){
                        synchronized(myCounter){
                            myCounter.counter++;
                        }
                        return true;
                    }
                    return false;
                })                
                .sum();
        System.out.println("sum: "+res+", counter="+myCounter.counter);
    }
    
}
