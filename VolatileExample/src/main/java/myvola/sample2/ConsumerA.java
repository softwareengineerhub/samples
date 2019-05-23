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
public class ConsumerA extends Thread {

    private SharedData sharedData;

    public ConsumerA(SharedData sharedData) {
        this.sharedData = sharedData;
    }

    @Override
    public void run() {
        int localValue = sharedData.value;
        while (localValue < 5) {
            if (localValue != sharedData.value) {
                localValue = sharedData.value;
                System.out.println("\tConsumed:" + localValue);
            }
        }
        System.out.println("\t---------Consumer Finished------");
    }
}
