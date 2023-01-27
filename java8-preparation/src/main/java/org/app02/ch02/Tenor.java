/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.app02.ch02;


/**
 *
 * @author dprokopiuk
 */
public class Tenor extends Singer {
    
    public static String sing(){
        return "fa";
    }
    
    public static void main(String[] args) {
        Tenor t = new Tenor();
        Singer s = new Tenor();
        System.out.println(t.sing()+" "+s.sing());
    }
    
}
