/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch02.stream.app3.methods;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

/**
 *
 * @author prokopiukd
 */
public class Main3 {
    
    public static void main(String[] args) {
        List<String> wordsList = Arrays.asList("Andrey","Boris","C","Denis","E");
        Stream<String> words = wordsList.stream();
        Stream<String> filteredWords = words.filter(s->s.length()>2);
        Stream<String> mappedWords = filteredWords.map(s->s.toUpperCase());
        Stream<String> flatMappedWords = mappedWords.flatMap((String t) -> Stream.of(t, t.toLowerCase()));
        flatMappedWords.forEach(System.out::println);
        System.out.println("----------------------");
        
        Stream<Integer> stream1 = Stream.of(1,2,3,4,5,6,7,8,9,10).skip(3);
        stream1.limit(5).forEach(System.out::println);
        System.out.println("----------------------");
        
        Stream<Integer> streamA = Stream.of(1,2,3,4,5);
        Stream<Integer> streamB = Stream.of(6,7,8,9,0);
        Stream<Integer> result1 = Stream.concat(streamA, streamB);
        result1.forEach(System.out::println);
        System.out.println("----------------------");
        
        Stream<Integer> streamC = Stream.of(1,2,3,4,5);
        Stream<Integer> streamD = Stream.of(6,7,8,9,0);
        Stream<Integer> result2 = Stream.concat(streamD, streamC);
        result2.forEach(System.out::println);
        System.out.println("----------------------");
        
        Stream<Integer> streamE = Stream.of(1,2,3,4,5,6,7,8,9,0);
        Stream<Integer> resultStreamE = streamE.peek((Integer t) -> {
            System.out.println(t);
        });
        System.out.println("----------------------");
        resultStreamE.forEach(System.out::println);
    }
    
}
