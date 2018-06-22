/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.file.mover.app;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<String> queue = new ArrayBlockingQueue<String>(10, true);        
        String toDirectory = "C:\\Test\\";        
        FileSearcher fileSearcher = new FileSearcher(queue);
        FileMover[] fileMovers = new FileMover[10];
        for (int i = 0; i < fileMovers.length; i++) {
            fileMovers[i] = new FileMover(queue, 1, toDirectory);
            fileMovers[i].start();
        }        
        String fromDirectory = "D:\\DATA\\";
        fileSearcher.findFile(fromDirectory);

    }

}
