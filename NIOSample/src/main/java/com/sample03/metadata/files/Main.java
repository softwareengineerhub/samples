/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sample03.metadata.files;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

/**
 *
 * @author prokopiukd
 */
public class Main {

    public static void main(String[] args) throws Exception {
        //
        byte[] data = Files.readAllBytes(Paths.get(Main.class.getResource("/data/nio-data.txt").toURI()));
        List<String> list = Files.readAllLines(Paths.get(Main.class.getResource("/data/nio-data1.txt").toURI()));

        try (BufferedReader reader = Files.newBufferedReader(Paths.get(Main.class.getResource("/data/nio-data1.txt").toURI()))) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        }
        Path path = Paths.get(Main.class.getResource("/data/nio-data-out.txt").toURI());
        try (OutputStream outputStream = Files.newOutputStream(path, StandardOpenOption.TRUNCATE_EXISTING)) {
            String text = "Test!!!";
            outputStream.write(text.getBytes());
            outputStream.flush();
        }

        try (InputStream inputStream = Files.newInputStream(path)) {
            byte[] contentBytes = new byte[inputStream.available()];
            String content = new String(contentBytes);
            System.out.println("content=" + content);
        }
        //Runtime.getRuntime().
        
    }

}
