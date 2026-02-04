/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.enthu.practice.ch06.exceptions.app06;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author admin
 */
public class Main {
    
    public static void main(String[] args) throws Exception {
        Path myfile = Paths.get("test.txt");
        try(BufferedReader bfr = Files.newBufferedReader(myfile, Charset.forName("US-ASCII") )){
            String line = null;
            while( (line = bfr.readLine()) != null){
                System.out.println(line);
            }
        }catch(Exception e){
            System.out.println(e);
        }
        
        
        Boo boo = new Boo();
        boo.type++;
        
        System.out.println(boo.age+"; "+boo.type);
        
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("boo.txt"));
        out.writeObject(boo);
        out.close();
        
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("boo.txt"));
        Boo boo2 = (Boo) in.readObject();
        Boo.type=100;
        System.out.println(boo2.age+"; "+boo2.type);
        
    }
    
    
    
}
