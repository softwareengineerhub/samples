/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kaplan.mock.sample02;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @author Denys.Prokopiuk
 */
public class Example {
    
    public static void main(String[] args) {
        AtomicInteger[] alarms = new AtomicInteger[10];
        for(int i=0;i<alarms.length;i++){
            alarms[i] = new AtomicInteger(i);
        }
        for(int i=0;i<alarms.length;i++){
            int res=alarms[i].incrementAndGet();
            System.out.println(res);
        }
        System.out.println(Arrays.toString(alarms));
    }
    
}
