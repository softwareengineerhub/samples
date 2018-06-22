/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BlockingQueue<String> queue = new ArrayBlockingQueue<>(10, true);
        //2 seconds
        for(int i=0;i<10;i++){
            Consumer c = new Consumer(queue);
            c.start();
        }
        
        //12 seconds
        /*for(int i=0;i<10;i++){
            Consumer c = new Consumer(queue);
            c.start();
        }*/
        
        
        Producer p = new Producer(queue);
        p.start();
    }
    
}
