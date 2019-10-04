/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch01.lambda.app02.methodref.inheritence;

/**
 *
 * @author DProkopiuk
 */
public class ConcurrentGreeter extends Greeter {
    
    public void greet(){
        Thread t = new Thread(super::greet);
        t.start();
    }
    
}
