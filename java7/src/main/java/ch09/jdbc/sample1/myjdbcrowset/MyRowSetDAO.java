/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch09.jdbc.sample1.myjdbcrowset;

import com.sun.rowset.JdbcRowSetImpl;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.rowset.JdbcRowSet;
import com.mysql.jdbc.Driver;
import java.sql.Statement;
import javax.sql.RowSetListener;

/**
 *
 * @author Denys.Prokopiuk
 */
public class MyRowSetDAO {

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void makeCall() {
        try (Connection c = getConnection()) {
            JdbcRowSet jdbcRowSet = new JdbcRowSetImpl(c);
            jdbcRowSet.setType(ResultSet.TYPE_SCROLL_INSENSITIVE);
            String sql = "SELECT * FROM denis.user_roles;";
            jdbcRowSet.setCommand(sql);
            jdbcRowSet.addRowSetListener(new MyListener());
            jdbcRowSet.execute();
            while (jdbcRowSet.next()) {
                System.out.println("id=" + jdbcRowSet.getString(1));
                System.out.println("login=" + jdbcRowSet.getString(2));
                System.out.println("pass=" + jdbcRowSet.getString(3));
                System.out.println("role=" + jdbcRowSet.getString(4));
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
