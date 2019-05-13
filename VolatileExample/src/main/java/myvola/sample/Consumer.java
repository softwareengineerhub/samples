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
public class Consumer extends Thread {

    private Main main;

    public Consumer(Main main) {
        this.main = main;
    }

    @Override
    public void run() {
        int localValue = main.value;
        while(localValue<5){
            if(localValue!=main.value){
                System.out.println("Change: "+main.value);
                localValue=main.value;
            }
        }
        System.out.println("Finish");
    }

}
