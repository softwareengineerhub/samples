/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sample06.random.access.file.io;

import java.io.File;
import java.io.RandomAccessFile;

/**
 *
 * @author prokopiukd
 */
public class DataSearcher {

    public byte[] readData(File file, int position, int size) {
        try {
            RandomAccessFile raf = new RandomAccessFile(file, "r");
            raf.seek(position);
            byte[] buffer = new byte[size];
            raf.read(buffer);
            raf.close();
            return buffer;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public void writeData(File file, int position) {
        try {
            RandomAccessFile raf = new RandomAccessFile(file, "rw");
            raf.seek(position);
            raf.writeUTF("@@@@@@@@@@@@@@@@@");
            //raf.writeChars("@@@@@@@@@@@@@@@@@");            
            raf.close();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

}
