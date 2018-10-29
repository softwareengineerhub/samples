/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch09.jdbc.sample2.mycachedrowset;

import ch09.jdbc.sample1.myjdbcrowset.MyListener;
import com.sun.rowset.CachedRowSetImpl;
import com.sun.rowset.JdbcRowSetImpl;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.JdbcRowSet;

/**
 *
 * @author Denys.Prokopiuk
 */
public class MyCachedRowSetDAO {
    
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void makeCall() {
        //try (Connection c = getConnection()) {
        try {
            CachedRowSet cachedRowSet = new CachedRowSetImpl();
            cachedRowSet.setUsername("root");
            cachedRowSet.setPassword("111111");
            cachedRowSet.setUrl("jdbc:mysql://localhost:3306/denis");
            cachedRowSet.setCommand("SELECT * FROM denis.user_roles");            
            cachedRowSet.execute();
            // cachedRowSet.addRowSetListener(new MyListener2());            
            while (cachedRowSet.next()) {
                System.out.println("id=" + cachedRowSet.getInt(1));
                System.out.println("login=" + cachedRowSet.getString(2));
                System.out.println("pass=" + cachedRowSet.getString(3));
                System.out.println("role=" + cachedRowSet.getString(4));
                System.out.println("------------------------------");
                if (1==cachedRowSet.getInt(1)) {
                    System.out.println("Remove #1");
                    cachedRowSet.deleteRow();
                    break;
                    //cachedRowSet.commit();
                }
            }
           
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    
}
