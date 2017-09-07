/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch01.lambda.app2.syntaxis;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author prokopiukd
 */
public class Main2 {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 5, 2, 9, 0, 2);
        list.sort((Integer a, Integer b) -> {
            return a - b;
        });
        System.out.println(list);
    }

}
