/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch01.lambda.app04.variablescope;

/**
 *
 * @author DProkopiuk
 */
public class Main {

    public static void main(String[] args) {
        repeatMessage("Hello", 100);
    }

    public static void repeatMessage(String text, int count) {
        Runnable r = () -> {

            for (int i = 0; i < count; i++) {
                System.out.println(text);
                Thread.yield();
            }

        };
        new Thread(r).start();
    }

}
