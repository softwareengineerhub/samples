/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kaplan.mock.sample06.code;

import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @author Denys.Prokopiuk
 */
public class MyAtomicInteger {
    
    public static void main(String[] args) {
        AtomicInteger[] array = new AtomicInteger[4];
        for (int i = 0; i < array.length; i++) {
            array[i] = new AtomicInteger(i);
            array[i].incrementAndGet();
            if(i==2){
                //array[i].compareAndSet(3, 4);
            }
         //array[i]++;
         //array[i]=array[i]+1;
        }
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
    
}
