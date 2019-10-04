/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch02.stream.app01.sub01;


import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author DProkopiuk
 */
public class Main {
        
    public static void main(String[] args) throws Exception {                
        String contents = new String(Files.readAllBytes(Paths.get(Main.class.getResource("/ch02/stream/app01/sub01/data.txt").toURI())));
        System.out.println(contents);
        List<String> words = Arrays.asList(contents.split(" "));
        System.out.println(words);
        int count = 0;
        for(String w: words){
            if(w.length()>12){
                count++;
            }
        }
        System.out.println(count);
    }
    
}
