/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.ch01.ejb.asynch;

import javax.ejb.Asynchronous;
import javax.ejb.Stateless;

/**
 *
 * @author denys.prokopiuk
 */
@Stateless
@Asynchronous
public class FireAndForgetImpl implements FireAndForget {

    @Override
    public void process(String message) {
        System.out.println("\tprocess().START");
        long start = System.currentTimeMillis();
        while(System.currentTimeMillis()-start<=30000){
            
        }
        System.out.println("\tprocess().END");
    }
    
}
