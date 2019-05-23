/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myvola.sample2;

/**
 *
 * @author Denys.Prokopiuk
 */
public class Main {
    //public volatile int value;
    private static SharedData sharedData = new SharedData();
    
    public static void main(String[] args) {
      //  Main main = new Main();
        ProducerA producerA = new ProducerA(sharedData);
        ConsumerA consumerA = new ConsumerA(sharedData);
        producerA.start();
        consumerA.start();
    }
    
}
