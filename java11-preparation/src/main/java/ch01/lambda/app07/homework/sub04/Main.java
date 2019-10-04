/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch01.lambda.app07.homework.sub04;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DProkopiuk
 */
public class Main {

    public static void main(String[] args) {
        String[] names = {"Peter", "Paul", "Mary"};
        List<Runnable> runners = new ArrayList();
        for (String name : names) {
            runners.add(() -> System.out.println(name));
        }
        for (Runnable r : runners) {
            new Thread(r).start();
        }
    }

}
