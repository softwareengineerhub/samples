/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myvola.sample3;

/**
 *
 * @author Denys.Prokopiuk
 */
public class Main {

    public static void main(String[] args) {
        CommonData commonData = new CommonData();
        ProducerB producerB = new ProducerB(commonData);
        ConsumerB consumerB = new ConsumerB(commonData);
        producerB.start();
        consumerB.start();
    }

}
