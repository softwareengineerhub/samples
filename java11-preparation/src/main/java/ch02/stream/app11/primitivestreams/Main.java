/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch02.stream.app11.primitivestreams;

import java.util.Arrays;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

/**
 *
 * @author asusadmin
 */
public class Main {
    
    public static void main(String[] args) {
        IntStream intStream = IntStream.of(1,2,3,4);
        int[] array = {0,1,2,3,4,5};
        IntStream intStream2 = Arrays.stream(array);
        
        //[)
        IntStream intStream3 = Arrays.stream(array, 1, 3);
        intStream3.forEach(System.out::println);
        System.out.println("--------------------------");
        
        //[)
        IntStream intStream4 = IntStream.range(0, 10);
        intStream4.forEach(System.out::println);
        System.out.println("--------------------------");
        
        //[]        
        IntStream intStream5 = IntStream.rangeClosed(0, 10);
        intStream5.forEach(System.out::println);
        System.out.println("--------------------------");
        
        long count = IntStream.of(1,2,3,4).count();
        
        OptionalDouble avg = IntStream.of(1,2,3,4).average();
        double avgVal = avg.getAsDouble();
        
        OptionalInt res = IntStream.of(1,2,3,4).max();
        OptionalInt res2 = IntStream.of(1,2,3,4).max();
        
        
        DoubleStream ds = IntStream.of(1,2,3,4).asDoubleStream();
        LongStream ls = IntStream.of(1,2,3,4).asLongStream();
        
    }
    
}
