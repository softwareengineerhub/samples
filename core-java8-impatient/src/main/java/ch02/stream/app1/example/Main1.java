/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch02.stream.app1.example;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author prokopiukd
 */
public class Main1 {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 9, 2, 6, 10, 5, -1, 4);
        int count = 0;
        for (int i : list) {
            if (i % 2 == 0) {
                count++;
            }
        }

        System.out.println(count);
        List<Integer> list1 = Arrays.asList(1, 9, 2, 6, 10, 5, -1, 4);
        count = (int) list1.stream().filter(i -> {
            System.out.println("i="+i+"; thread="+Thread.currentThread());
            return i % 2 == 0;
        }).count();
        System.out.println(count);
    }

}
