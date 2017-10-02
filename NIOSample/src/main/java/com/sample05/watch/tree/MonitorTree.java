/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sample05.watch.tree;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.HashMap;
import java.util.Map;
import static java.nio.file.StandardWatchEventKinds.*;
import java.nio.file.WatchEvent;
import java.util.List;

/**
 *
 * @author prokopiukd
 */
public class MonitorTree {

    private WatchService watchService;
    private final Map<WatchKey, Path> directories = new HashMap();

    public void watchRNDir(Path start) throws Exception {
        watchService = FileSystems.getDefault().newWatchService();
        registerTree(start);
        while (true) {
            WatchKey watchKey = watchService.take();
            List<WatchEvent<?>> list = watchKey.pollEvents();
            for (WatchEvent we : list) {
                System.out.println("Kind=" + we.kind() + "; count=" + we.count() + "; context=" + we.context());
                if (we.kind() == ENTRY_CREATE) {
                    if (we.context() instanceof Path) {
                        Path fileName = (Path) we.context();
                        Path dirPath = directories.get(watchKey);
                        Path child = dirPath.resolve(fileName);
                        if (Files.isDirectory(child)) {
                            registerTree(child);
                        } else {
                            registerPath(child);
                        }
                    }
                }
            }
            watchKey.reset();
        }
    }

    private void registerPath(Path path) throws IOException {
        WatchKey watchKey = path.register(watchService, ENTRY_CREATE, ENTRY_DELETE, ENTRY_MODIFY);
        directories.put(watchKey, path);
    }

    private void registerTree(Path path) throws IOException {
        Files.walkFileTree(path, new SimpleFileVisitor<Path>() {

            @Override
            public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                registerPath(dir);
                return FileVisitResult.CONTINUE;
            }

        });

        WatchKey watchKey = path.register(watchService, ENTRY_CREATE, ENTRY_DELETE, ENTRY_MODIFY);
        directories.put(watchKey, path);
    }

}
