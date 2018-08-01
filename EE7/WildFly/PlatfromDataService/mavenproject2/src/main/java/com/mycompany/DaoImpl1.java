/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany;

import org.springframework.stereotype.Component;

/**
 *
 * @author denys.prokopiuk
 */
@Component
public class DaoImpl1 implements Dao {
       
    
    @Override
    public void makeAction() {
        System.out.println("DaoImpl1.action()");
    }

}
