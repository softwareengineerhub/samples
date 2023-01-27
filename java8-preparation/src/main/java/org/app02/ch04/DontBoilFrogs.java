/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.app02.ch04;

/**
 *
 * @author dprokopiuk
 */
public class DontBoilFrogs implements FrogBoilable {
    
    public static void main(String[] args) {
        new DontBoilFrogs().go();
    }
    
    void go(){
        System.out.println(hop());
        //System.out.println(getCtoF(100));
        System.out.println(FrogBoilable.getCtoF(100));
        DontBoilFrogs dbf = new DontBoilFrogs();
        //System.out.println(dbf.getCtoF(100));        
    }
    
}
