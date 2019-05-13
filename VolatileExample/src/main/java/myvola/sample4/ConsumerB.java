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
public class ConsumerB extends Thread {

    private Main main;

    public ConsumerB(Main main) {
        this.main = main;
    }

    @Override
    public void run() {
        CommonData localCommonData = main.commonData;
        while(localCommonData.getValue()<5){
            if(localCommonData.getValue()!=main.commonData.getValue()){
                localCommonData = main.commonData;
                System.out.println("\tConsumed: "+localCommonData.getValue());
            }
        }
        System.out.println("-------------Consumer finished-----------------");
    }

}
