/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch01.lambda.app1.example;

/**
 *
 * @author prokopiukd
 */
public class Main1 {

    public static void main(String[] args) {
        Worker worker = new Worker();
        Thread t = new Thread(worker);
        t.start();
        Thread t1 = new Thread(() -> System.out.println("This is lambda"));
        t1.start();
    }

}
