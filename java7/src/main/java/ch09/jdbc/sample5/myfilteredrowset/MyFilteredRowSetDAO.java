/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch09.jdbc.sample5.myfilteredrowset;

import com.sun.rowset.CachedRowSetImpl;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.FilteredRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

/**
 *
 * @author Denys.Prokopiuk
 */
public class MyFilteredRowSetDAO {

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void makeCall() {
        try (Connection c = getConnection()) {
            RowSetFactory factroy = RowSetProvider.newFactory();
            FilteredRowSet frs = factroy.createFilteredRowSet();
            frs.setCommand("SELECT * FROM denis.user_roles");
            frs.execute(c);
            frs.setFilter(new MyFilter());

            while (frs.next()) {
                System.out.println("id=" + frs.getInt(1));
                System.out.println("login=" + frs.getString(2));
                System.out.println("pass=" + frs.getString(3));
                System.out.println("role=" + frs.getString(4));
                System.out.println("------------------------------");
                
            }

        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/denis", "root", "111111");
    }

}
