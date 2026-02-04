/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.enthu.practice.ch06.exceptions.app05;

/**
 *
 * @author admin
 */
public class Main05 {
    
    public static void main(String[] args) throws Exception {
        try(Device d = new Device()){
            throw new Exception("here");
        }
    }
    
}
