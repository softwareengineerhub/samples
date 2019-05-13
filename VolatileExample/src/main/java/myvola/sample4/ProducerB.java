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
public class ProducerB extends Thread {

    private Main main;

    public ProducerB(Main main) {
        this.main = main;
    }

    @Override
    public void run() {
        CommonData localCommonData = main.commonData;
        while (localCommonData.getValue() < 5) {
            localCommonData.setValue(localCommonData.getValue()+1);
            main.commonData=localCommonData;
            pause(1000);
            System.out.println("Produced: " + localCommonData.getValue());
        }
        System.out.println("---------Producer finished---------");
    }
    
    private void pause(long delay){
        long start = System.currentTimeMillis();
        while(System.currentTimeMillis()-start<=delay){            
        }
    }

}
