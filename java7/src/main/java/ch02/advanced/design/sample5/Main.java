/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch02.advanced.design.sample5;

import ch02.advanced.design.sample5.Sample5.A;

/**
 *
 * @author Denys.Prokopiuk
 */
public class Main {
 
    public static void main(String[] args) {
        A[] values = Sample5.A.values();
        for(A a: values){
            System.out.println("value="+a);
        }
        
    }
    
}
