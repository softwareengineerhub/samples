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
public class Producer extends Thread {

    private Main main;

    public Producer(Main main) {
        this.main = main;
    }

    @Override
    public void run() {
        int localValue = main.value;
        while (localValue < 5) {
           // System.out.println("");
           localValue++;
           main.value=localValue;
            pause(1000);
        }
        System.out.println("---Producer finish--");
    }
    
    private void pause(long delay) {
        long start = System.currentTimeMillis();
        while (System.currentTimeMillis() - start <= delay) {
        }
    }

}
