/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch02.stream.app14.flatmap;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * @author asusadmin
 */
public class Main {
    
    public static void main(String[] args) {
        List list1 = Arrays.asList("a","b","c");
        List list2 = Arrays.asList("d","e","f");
        List list3 = Arrays.asList("g","h","i");
        List res = (List) Stream.of(list1, list2, list3).flatMap(list->list.stream()).collect(Collectors.toList());
        System.out.println(res);
    }
    
}
