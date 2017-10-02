/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sample06.random.access.file.io;

import java.io.File;

/**
 *
 * @author prokopiukd
 */
public class Main {

    public static void main(String[] args) {
        //File file = new File(Main.class.getResource("/data/nio-data.txt").getFile());
        File file = new File("C:\\Denis\\Document.txt");
        DataSearcher dataSearcher = new DataSearcher();
        dataSearcher.writeData(file, 5);
        
        byte[] data = dataSearcher.readData(file, 100, 10);
        System.out.println(new String(data));
        
    }

}
