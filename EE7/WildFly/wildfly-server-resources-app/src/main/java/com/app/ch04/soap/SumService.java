/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.ch04.soap;

import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 *
 * @author denys.prokopiuk
 * 
 * 
 * Still use EJB Pool
 */
@Stateless
@WebService
public class SumService {
    
    @WebMethod
    public int add(int a, int b){
        System.out.println("@START "+hashCode());
        long start = System.currentTimeMillis();
        while(System.currentTimeMillis()-start<=30000){            
        }
        System.out.println("@END "+hashCode());
        System.out.println("@SOAP WEB SERVICE. hashCode="+hashCode());
        return a+b;
    }
    
}
