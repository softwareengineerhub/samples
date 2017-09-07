/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch02.stream.app2.creation;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 *
 * @author prokopiukd
 */
public class Main2 {

    public static void main(String[] args) {
        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 0);
        String[] words = {"A", "B", "C", "D", "E",};
        Stream<String> stream1 = Arrays.stream(words);
        
        List<Integer> numbersList = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        Stream<Integer> stream2 = numbersList.stream();
    }

}
