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
public class ConsumerB extends Thread {

    private CommonData commonData;

    public ConsumerB(CommonData commonData) {
        this.commonData = commonData;
    }

    @Override
    public void run() {
        int localValue = commonData.getValue();
        while(localValue<5){
            if(localValue!=commonData.getValue()){
                localValue = commonData.getValue();
                System.out.println("\tConsumed: "+localValue);
            }
        }
        System.out.println("-------------Consumer finished-----------------");
    }

}
