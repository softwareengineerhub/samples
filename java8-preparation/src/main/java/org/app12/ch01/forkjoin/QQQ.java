/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.app12.ch01.forkjoin;

import java.util.Optional;

/**
 *
 * @author admin
 */
public class QQQ {
    
    public static void main(String[] args) {
        String value = "DenYs";
        String res = "%"+ value.toLowerCase() +"%";
        System.out.println("res="+res);
        
        Optional<String> opt = Optional.empty();
        String val = opt.orElse(null);
        System.out.println("val="+val);
    }
    
}
