/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch03.nio.app01;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/**
 *
 * @author asusadmin
 */
public class Main {

    public static void main(String[] args) throws IOException {
       /* 
       Path path1 = Paths.get("file1.txt");
        Path path2 = Paths.get("file2.txt");
        //Files.copy(path1, path2, StandardCopyOption.COPY_ATTRIBUTES);
        Files.copy(path1, path2, StandardCopyOption.REPLACE_EXISTING);*/
       
       
        File file = new File("somefile.txt");
        Path path3 = Paths.get(file.toURI());
        Object res = Files.readAttributes(path3, "size");
        System.out.println(res.getClass());
        System.out.println(Files.readAttributes(path3, "size"));
    }

}
