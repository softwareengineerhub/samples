/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch01.design.com.app;

import java.sql.SQLException;

/**
 *
 * @author Denys.Prokopiuk
 */
public class Data implements Inter1, Inter2 {

    @Override
    public void m1() {
      //  System.out.println(t1);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void m2() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
