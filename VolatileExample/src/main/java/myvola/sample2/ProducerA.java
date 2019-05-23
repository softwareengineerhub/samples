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
public class ProducerA extends Thread {

    private SharedData sharedData;

    public ProducerA(SharedData sharedData) {
        this.sharedData = sharedData;
    }
    
    @Override
    public void run(){
        int localValue = sharedData.value;
        while(localValue<5){
            localValue++;
            sharedData.value=localValue;
            pause(1000);
        }
        System.out.println("Producer finished");
        
    }
    
    private void pause(long delay){
        long start = System.currentTimeMillis();
        while(System.currentTimeMillis()-start<=delay){            
        }
    }

}
