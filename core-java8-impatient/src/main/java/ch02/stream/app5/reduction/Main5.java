/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch02.stream.app5.reduction;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 *
 * @author prokopiukd
 */
public class Main5 {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Stream<Integer> stream = list.stream();
        Optional<Integer> largest = stream.max((Integer o1, Integer o2) -> o1 - o2);
        if (largest.isPresent()) {
            int max = largest.get();
            System.out.println("Max=" + max);
        }
        //this is almost smae as 
        Integer val = largest.get();
        if (val != null) {

        }

        largest.orElse(0);
        largest.orElseGet(() -> 0);
        largest.orElseThrow(new Supplier<NoSuchElementException>() {

            @Override
            public NoSuchElementException get() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

        });

        System.out.println("-------------------------");
        Stream<Integer> streamA = Stream.of(1, 2, 3, 4);
        Optional<Integer> sum = streamA.reduce((a, b) -> a + b);
        System.out.println("sum="+sum);
    }

}
