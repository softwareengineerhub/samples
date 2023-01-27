package com.book.ch12.jdbc.app03;

import java.sql.*;

public class AppStarter03 {

    public static void main(String[] args) throws SQLException {
        m2();
    }

    private static void m2() throws SQLException {
        try (Connection c = getConnection()) {
            Statement st = c.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = st.executeQuery("select * from person");

            rs.moveToInsertRow();
            rs.updateInt("id", 5);
            rs.updateInt("age", 5);
            rs.updateString("name", "Denys");
            rs.insertRow();

            while(rs.next()){
                String name = rs.getString("name");
                System.out.println("------name="+name);
            }
        }
    }

    private static void m1() throws SQLException {
        try (Connection c = getConnection()) {
            Statement st = c.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = st.executeQuery("select * from person");
            rs.first();
            rs.updateString("name", "s2");
            rs.updateRow();
            System.out.println("--------------");
            rs.beforeFirst();
            while(rs.next()){
                String name = rs.getString("name");
                System.out.println("------name="+name);
            }
        }
    }

    private static Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/my?useSSL=false", "root", "11111111");
    }

}
