/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch09.jdbc.sample5.examples;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Denys.Prokopiuk
 */
public class MultipleQueriesExample {

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            throw new RuntimeException(ex);
        }
    }

    public static void main(String[] args) throws SQLException {
        try (Connection c = getConnection()) {
            System.out.println("Connection - OK");
            Statement st = c.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM customer");
            //Exception in thread "main" java.sql.SQLException: Operation not allowed after ResultSet closed
            //st.executeQuery("SELECT * FROM student");
            while(rs.next()){
                System.out.println(rs.getObject("name"));
            }
        }
    }

    private static Connection getConnection() throws SQLException {
         return DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb", "root", "111111");
    }

}
