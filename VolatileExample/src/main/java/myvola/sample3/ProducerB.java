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
public class ProducerB extends Thread {

    private CommonData commonData;

    public ProducerB(CommonData commonData) {
        this.commonData = commonData;
    }

    @Override
    public void run() {
        int localValue = commonData.getValue();
        while (localValue < 5) {
            localValue++;
            commonData.setValue(localValue);
            pause(1000);
            System.out.println("Produced: " + localValue);
        }
        System.out.println("---------Producer finished---------");
    }
    
    private void pause(long delay){
        long start = System.currentTimeMillis();
        while(System.currentTimeMillis()-start<=delay){            
        }
    }

}
