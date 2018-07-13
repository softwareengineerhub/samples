/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.ch01.ejb.asynch;

/**
 *
 * @author denys.prokopiuk
 */
public interface FireAndForget {
    
    public void process(String message);
    
}
