/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.enthu.practice.ch06.exceptions.app04;

import java.io.FileReader;
import java.sql.Connection;

/**
 *
 * @author admin
 */
public class Main04 {
    
    public static void main(String[] args) {
        try {
            Main04 main = new Main04();
            main.readData("C:\\Soft\\payara6\\README.txt");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
     public void readData(String fileName) throws Exception {    
         try(FileReader fr1 = new FileReader(fileName)){ 
             Connection c = getConnection();
         }
     }
     
     
     private Connection getConnection() throws ClassNotFoundException {
         throw new ClassNotFoundException();
     }
    
}
