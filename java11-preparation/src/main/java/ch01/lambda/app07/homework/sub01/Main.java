/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch01.lambda.app07.homework.sub01;

import java.util.Arrays;
import java.util.Comparator;

/**
 *
 * @author DProkopiuk
 */
public class Main {

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getId());
        Integer[] data = {2, 4, 5, 0, -2, 8, 9};
        /*Arrays.sort(data, (int a, int b) -> {
            return Integer.compare(a, b);
        });*/

        Comparator<Integer> c = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                System.out.println("\t"+Thread.currentThread().getId());
                return o1.compareTo(o2);
            }
        };
        
        Arrays.sort(data, c);        
        
        System.out.println("--------------------------");
        Comparator<Integer> c1 = (a, b) -> {
            return Integer.compare(a, b);
        };
        
        Arrays.sort(data, c1);        
    }

}
