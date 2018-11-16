/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch07.iodata.sample01;

import java.io.FileNotFoundException;
import java.io.RandomAccessFile;

/**
 *
 * @author Denys.Prokopiuk
 */
public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        //DataOutput, DataInput, Closeable
        
        RandomAccessFile randomAccessFile = new RandomAccessFile("", "");
        
        //BufferedReader handle = new BufferedReader(new FileReader(fullFilePath));
        //BufferedReader handle = new BufferedReader(new FileReader( new File(fullFilePath)));
        
        //raf.seek( raf.length() ); - to the end onf the file
    }
    
}
