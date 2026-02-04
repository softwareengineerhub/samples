/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.enthu.practice.ch06.exceptions.app03;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * @author admin
 */
public class Main03 {
    
    public static void main(String[] args){
        try{
            FileOutputStream out = new FileOutputStream(new File(""));
        
            
        }
        catch(IOException | RuntimeException e){
            e.printStackTrace();
        }
    }
            
    
}
