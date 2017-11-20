/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.files;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

/**
 *
 * @author prokopiukd
 */
public class FilesApp {

    public static void main(String[] args) throws Exception {
        //File folder = new File("C:\\Users\\prokopiukd\\Documents\\NetBeansProjects\\Recursion\\abc");
        File folder = new File("/");
        if (!folder.exists()) {
            folder.mkdir();
        }
        System.out.println(folder.getAbsolutePath());
        String path = "/";
        String content = "<html><body><div>Hello</div></body></html>";
        File file = new File("test.html");
        try (OutputStream out = new FileOutputStream(file)) {
            out.write(content.getBytes());
        }
    }

}
