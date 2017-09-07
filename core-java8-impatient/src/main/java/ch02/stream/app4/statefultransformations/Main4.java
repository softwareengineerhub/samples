/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch02.stream.app4.statefultransformations;

import java.util.stream.Stream;

/**
 *
 * @author prokopiukd
 */
public class Main4 {
    
    public static void main(String[] args) {
        // Stateless - when an element is retrieved from a filtered or mapped stream, the answe does not depend on the previous elements.
        
        //Stateful - distinct. Returns a stream that yields elements from the original stream, in the same order, except that duplicates are suppressed.
        
        Stream.of(1, 2, 3, 4, 2, 4).distinct().forEach(System.out::println);
    }
    
}
