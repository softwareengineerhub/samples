/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch01.lambda.app02.methodref.inheritence;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DProkopiuk
 */
public class Greeter {
    
    public void greet(){
        int i = 0;
        while(true){
            System.out.println("Hello, World! "+i);
            i++;
            if(i==10){
                break;
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }
    
}
