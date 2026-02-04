/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.enthu.practice.ch06.exceptions.app05;

import java.io.Console;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author admin
 */
public class Main051 {
    
    public static void main(String[] args) {
        try {
            m();
        } catch (Exception ex) {
            Throwable[] th = ex.getSuppressed();
            for(Throwable t: th){
                t.printStackTrace();
            }
        }
    }
    
    
    private static void m() throws Exception {
        try(Device d = new Device()){
            throw new Exception("here");
        }
    }
    
}
