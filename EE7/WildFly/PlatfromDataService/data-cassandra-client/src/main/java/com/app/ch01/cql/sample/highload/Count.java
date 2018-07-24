/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.ch01.cql.sample.highload;

import com.app.ch01.cql.sample.DAO;
import com.app.ch01.cql.sample.DAOImpl4;

/**
 *
 * @author denys.prokopiuk
 */
public class Count {
    
     public static void main(String[] args) {
        DAO dao = new DAOImpl4();
        long count=dao.count();
        System.out.println("count="+count);
        
    }
    
    
}
