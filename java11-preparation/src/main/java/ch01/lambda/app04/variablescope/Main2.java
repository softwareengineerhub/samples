/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch01.lambda.app04.variablescope;

/**
 *
 * @author asusadmin
 */
public class Main2 {
static int t=10;
    public static void main(String[] args) {
            
            repeatMessage("sadsada", 0);
    }

    public static void repeatMessage(String text, int count) {
        Runnable r = () -> {
            while (count > 0) {
                //count--; // Error: Can’t mutate captured variable
                System.out.println(text);
                Thread.yield();
            }
        };
        new Thread(r).start();
    }
}
