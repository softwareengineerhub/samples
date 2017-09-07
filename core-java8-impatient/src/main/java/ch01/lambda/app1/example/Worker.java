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
public class Worker implements Runnable {

    @Override
    public void run() {
        System.out.println("Task");
    }
    
}
