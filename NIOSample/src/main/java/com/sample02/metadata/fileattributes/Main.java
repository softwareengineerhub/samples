/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sample02.metadata.fileattributes;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.FileStore;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.FileTime;
import java.util.Calendar;
import java.util.Date;
import java.util.Set;

/**
 *
 * @author prokopiukd
 */
public class Main {

    public static void main(String[] args) throws Exception {
        FileSystem fs = FileSystems.getDefault();
        Set<String> views = fs.supportedFileAttributeViews();
        for (String view : views) {
            System.out.println(view);
        }

        for (FileStore store : fs.getFileStores()) {
            boolean basicSupport = store.supportsFileAttributeView(BasicFileAttributeView.class);
            boolean userSupport = store.supportsFileAttributeView("user");
            System.out.println("basicSupport=" + basicSupport);
            System.out.println("userSupport=" + userSupport);
        }

        //------Basic View-----------
        //Read attribute
        URL url = Main.class.getResource("/data/nio-data1.txt");
        Path path = Paths.get(url.toURI());
        System.out.println(path);
        Object sizeAttribute = Files.getAttribute(path, "basic:size");
        System.out.println("sizeAttribute=" + sizeAttribute);
        Object creationTimeAttribute = Files.getAttribute(path, "basic:creationTime");
        System.out.println("creationTimeAttribute=" + creationTimeAttribute);

        //Write attribute
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, 1986);
        FileTime fileTime = FileTime.fromMillis(calendar.getTimeInMillis());
        Path updatePath = Files.setAttribute(path, "basic:creationTime", fileTime);
        System.out.println("updatePath=" + updatePath);
        creationTimeAttribute = Files.getAttribute(path, "basic:creationTime");
        System.out.println("creationTimeAttribute=" + creationTimeAttribute);
        
    }

}
