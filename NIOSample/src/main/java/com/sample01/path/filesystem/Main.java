/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sample01.path.filesystem;

import java.net.URL;
import java.nio.file.FileStore;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.spi.FileSystemProvider;
import java.util.Set;

/**
 *
 * @author prokopiukd
 */
public class Main {

    public static void main(String[] args) throws Exception {
        FileSystem fileSystem = FileSystems.getDefault();
        Set<String> supportedFileAttributeViews = fileSystem.supportedFileAttributeViews();

        System.out.println(supportedFileAttributeViews);
        for (FileStore logicalDisks : fileSystem.getFileStores()) {
            System.out.println(logicalDisks);
        }

        for (Path rootDirectory : fileSystem.getRootDirectories()) {
            System.out.println(rootDirectory);
        }

        String separator = fileSystem.getSeparator();
        System.out.println("separator=" + separator);

        FileSystemProvider fileSystemProvider = fileSystem.provider();
        System.out.println(fileSystemProvider);

        URL url = Main.class.getResource("/data/nio-data1.txt");
        Files.readAllBytes(Paths.get(url.toURI()));
    }

}
