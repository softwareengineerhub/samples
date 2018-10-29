/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch09.jdbc.sample4.myjoinrowset;

import com.sun.rowset.CachedRowSetImpl;
import com.sun.rowset.JoinRowSetImpl;
import com.sun.rowset.WebRowSetImpl;
import java.io.FileOutputStream;
import java.io.OutputStream;
import javax.sql.rowset.JoinRowSet;
import javax.sql.rowset.WebRowSet;

/**
 *
 * @author Denys.Prokopiuk
 */
public class MyJoinRowSetDAO {

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void makeCall() {
        try (OutputStream out = new FileOutputStream("webrowset.xml")) {
            CachedRowSetImpl customers = new CachedRowSetImpl();            
            CachedRowSetImpl associates = new CachedRowSetImpl();
            
            JoinRowSet jrs = new JoinRowSetImpl();
            jrs.addRowSet(customers, "id");
            jrs.addRowSet(associates, "id");
            
          //  WebRowSet wrs = new WebRowSetImpl();
            jrs.setUsername("root");
            jrs.setPassword("111111");
            jrs.setUrl("jdbc:mysql://localhost:3306/denis");
            jrs.setCommand("SELECT * FROM denis.user_roles");
            jrs.execute();
            
             while (jrs.next()) {
                System.out.println("id=" + jrs.getInt(1));
                System.out.println("login=" + jrs.getString(2));
                System.out.println("pass=" + jrs.getString(3));
                System.out.println("role=" + jrs.getString(4));
                System.out.println("------------------------------");                
            }
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

}
