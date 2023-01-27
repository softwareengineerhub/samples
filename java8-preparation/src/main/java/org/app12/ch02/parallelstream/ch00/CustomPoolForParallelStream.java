/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.app12.ch02.parallelstream.ch00;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;

/**
 *
 * @author dprokopiuk
 */
public class CustomPoolForParallelStream {
    
    public static void main(String[] args) throws Exception {
        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        
        ForkJoinPool fjp = new ForkJoinPool(2);
        ForkJoinTask<Integer> res = fjp.submit(new Callable<Integer>() {
            
            @Override
            public Integer call() throws Exception {
                return nums.stream()
                        .parallel()
                        .peek(i->
                        {
                            try {
                                Thread.sleep(2000);
                            } catch (Exception ex) {
                                ex.printStackTrace();
                            }
                            System.out.println(i+": "+Thread.currentThread().getName());
                        }
                        )
                        .mapToInt(i->i)
                        .sum();
            }
        });
        int a = res.get();
        System.out.println("a="+a);
    }
    
}
