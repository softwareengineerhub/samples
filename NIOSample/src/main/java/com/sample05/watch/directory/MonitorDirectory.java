/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sample05.watch.directory;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import static java.nio.file.StandardWatchEventKinds.*;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author prokopiukd
 */
public class MonitorDirectory {

    public static void main(String[] args) throws IOException {

        Thread t = new Thread() {

            @Override
            public void run() {
                try (WatchService watchService = FileSystems.getDefault().newWatchService()) {
                    Path path = Paths.get("C:\\Denis");
                    path.register(watchService, ENTRY_CREATE, ENTRY_DELETE, ENTRY_MODIFY);
                    while (true) {
                        //WatchKey wk = watchService.poll();                       
                        WatchKey wk = watchService.take();
                        if (wk != null) {
                            if (wk.isValid()) {
                                List<WatchEvent<?>> list = wk.pollEvents();
                                for (WatchEvent we : list) {
                                    System.out.println("Kind=" + we.kind() + "; count=" + we.count() + "; context=" + we.context());
                                }
                            }
                            wk.reset();
                        }
                        Thread.sleep(2000);
                    }
                } catch (Exception ex) {
                    Logger.getLogger(MonitorDirectory.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        };
        //t.setDaemon(true);
        t.start();
    }

}
