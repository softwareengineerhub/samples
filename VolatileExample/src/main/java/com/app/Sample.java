/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app;

/**
 *
 * @author prokopiukd
 */
public class Sample {

    static int i;

    public static void main(String[] args) {
        new MyThreadWrite().start();
        new MyThreadRead().start();
    }

    static class MyThreadWrite extends Thread {

        @Override
        public void run() {
            while (i < 5) {
                System.out.println("Produced: " + (++i));
                try {
                    Thread.sleep(500);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }

        }
    }

    static class MyThreadRead extends Thread {

        @Override
        public void run() {
            int localValue = i;
            while (localValue < 5) {
                if (localValue != i) {
                    System.out.println("\tlocalValue=" + localValue);
                    localValue = i;
                }
            }
        }
    }

}
