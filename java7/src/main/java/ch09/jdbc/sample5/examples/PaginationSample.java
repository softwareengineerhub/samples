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
public class PaginationSample {

    public static void main(String[] args) throws SQLException {
        try (Connection c = getConnection()) {
            Statement st = c.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
           // st.setMaxRows(2);
            ResultSet rs = st.executeQuery("SELECT * FROM student");
            //rs.absolute(1);
            //rs.setFetchSize(1);
            while (rs.next()) {
                delay(5000);
                System.out.println(rs.getObject(1));
                System.out.println(rs.getObject("name"));
                delay(5000);
            }
            System.out.println("-----------------");
            while (rs.previous()) {
                System.out.println(rs.getObject(1));
            }
            System.out.println("-----------------");
            while (rs.next()) {
                System.out.println(rs.getObject(1));
            }
            System.out.println("-----------------");
            rs.absolute(1);
            System.out.println(rs.getObject(1));
            System.out.println("Finish");
        }
    }

    private static Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb", "root", "111111");
    }
    
    private static void delay(long time){
        long start = System.currentTimeMillis();
        while(System.currentTimeMillis()-start<=time){            
        }
    }

}
