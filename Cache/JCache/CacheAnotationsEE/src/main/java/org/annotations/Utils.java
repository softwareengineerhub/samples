/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.annotations;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author denys
 */
@ApplicationScoped
public class Utils {
 
    public void method(){
        System.out.println("Method");
    }
    
}
