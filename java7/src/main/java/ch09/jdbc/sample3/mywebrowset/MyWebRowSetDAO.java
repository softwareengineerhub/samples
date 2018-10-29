/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch09.jdbc.sample3.mywebrowset;

import com.sun.rowset.CachedRowSetImpl;
import com.sun.rowset.WebRowSetImpl;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.WebRowSet;

/**
 *
 * @author Denys.Prokopiuk
 */
public class MyWebRowSetDAO {
    
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void makeCall() {
        try (OutputStream out = new FileOutputStream("webrowset.xml")) {
            WebRowSet wrs = new WebRowSetImpl();
            wrs.setUsername("root");
            wrs.setPassword("111111");
            wrs.setUrl("jdbc:mysql://localhost:3306/denis");
            wrs.setCommand("SELECT * FROM denis.user_roles");
            wrs.execute();
            wrs.writeXml(out);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

}
