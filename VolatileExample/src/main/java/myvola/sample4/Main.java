/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myvola.sample4;

/**
 *
 * @author Denys.Prokopiuk
 */
public class Main {

    //public volatile CommonData commonData = new CommonData();
    public CommonData commonData = new CommonData();

    public static void main(String[] args) {
        Main main = new Main();

        ProducerB producerB = new ProducerB(main);
        ConsumerB consumerB = new ConsumerB(main);
        producerB.start();
        consumerB.start();
    }

}
