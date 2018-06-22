/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org;

import java.util.concurrent.BlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Producer extends Thread  {
    private BlockingQueue<String> queue;
    private int i;

    public Producer(BlockingQueue<String> queue) {
        this.queue = queue;
    }
    
    @Override
    public void run(){
        while(true){
            try {                
                System.out.println("Produce: "+i);
                queue.put(""+i);
                if(i>100){
                    queue.put("-1");
                    break;
                }
                i++;
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }
    
}
