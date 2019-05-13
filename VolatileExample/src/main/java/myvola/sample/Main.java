/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myvola.sample;

/**
 *
 * @author Denys.Prokopiuk
 */
public class Main {
    
    public int value;
    
    
    public static void main(String[] args) {
        Main main = new Main();
        Producer producer = new Producer(main);
        Consumer consumer = new Consumer(main);
        
        producer.start();
        consumer.start();
    }
    
}
