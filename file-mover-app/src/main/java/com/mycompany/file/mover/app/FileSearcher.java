/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.file.mover.app;

import java.io.File;
import java.util.concurrent.BlockingQueue;

public class FileSearcher {

    private BlockingQueue<String> queue;

    public FileSearcher(BlockingQueue queue) {
        this.queue = queue;
    }

    public void findFile(String rootDir) {
        try {
            search(rootDir);        
            queue.put("-1");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void search(String rootDir) throws Exception {
        File file = new File(rootDir);
        if (!file.isDirectory()) {
            //System.out.println("Put " + file);
            queue.put(file.getAbsolutePath());
        } else {
            File[] files = file.listFiles();
            if (files != null) {
                for (File f : files) {
                    search(f.getAbsolutePath());
                }
            }
        }
    }

}
