/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.simpleprogrammer.actions;

/**
 *
 * @author Denis
 */
public class ProteinTrackingService {
    private int enteredProtein;

    public void addProtein(int enteredProtein){        
        this.enteredProtein+=enteredProtein;
    }
    
    public int getSumOfProtein(){
        return enteredProtein;
    }
    
}
