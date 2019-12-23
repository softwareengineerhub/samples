/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch03.nio.app02;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import static java.nio.file.StandardOpenOption.APPEND;

/**
 *
 * @author asusadmin
 */
public class Main {
    
    public static void main(String[] args) throws IOException {
        OpenOption[] options = new OpenOption[2];
        options[0] = APPEND;
        options[1] = StandardOpenOption.WRITE;
        
        options[0] = APPEND;
        options[1] = StandardOpenOption.SYNC;
        
        //options[0] = APPEND;
        //options[1] = StandardOpenOption.TRUNCATE_EXISTING;
        
        
        File file = new File("somefile.txt");
        Files.write(Paths.get(file.toURI()), "fsdfsfsdfs".getBytes(), options);
    }
    
}
