/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch02.stream.app6.collectors;

import java.util.stream.Stream;

/**
 *
 * @author prokopiukd
 */
public class Main6 {

    public static void main(String[] args) {
        
        //1. use array
        Stream<Integer> streamA = Stream.of(1, 2, 3, 4, 5, 6);
        Integer[] array = streamA.toArray(Integer[]::new);

        //2. Iterator:
        Stream<Integer> streamB = Stream.of(1, 2, 3, 4, 5, 6);
        streamB.forEach(System.out::println);
        
    }
}
