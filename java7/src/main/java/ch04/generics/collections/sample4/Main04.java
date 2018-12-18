/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch04.generics.collections.sample4;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Denys.Prokopiuk
 */
public class Main04 {
    
    public static void main(String[] args) {
        List<? extends MyParent04> list = new ArrayList<MyChild04A>();
        
    }
    
}
