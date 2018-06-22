/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org;

import java.util.concurrent.BlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Consumer extends Thread {

    private BlockingQueue<String> queue;

    public Consumer(BlockingQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                String res = queue.take();
                System.out.println("\tConsumes: "+res+"    Thread.name:"+getName());
                if ("-1".equalsIgnoreCase(res)) {
                    queue.put("-1");
                    break;                    
                }
                Thread.sleep(100);
            } catch (Exception ex) {
                ex.printStackTrace();
            }

        }
    }

}
