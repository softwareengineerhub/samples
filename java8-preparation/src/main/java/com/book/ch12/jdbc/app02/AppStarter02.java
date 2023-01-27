package com.book.ch12.jdbc.app02;

import java.sql.*;

public class AppStarter02 {

    public static void main(String[] args) throws SQLException {
        m3();
    }

    private static void m3() throws SQLException {
        try (Connection c = getConnection()) {
            Statement st = c.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = st.executeQuery("select * from person");

            boolean res = rs.absolute(2);
            rs.relative(-1);
            rs.relative(1);
            rs.relative(1);
            int row = rs.getRow();
            System.out.println("row="+row);
            //res = rs.absolute(1);
            System.out.println("res="+res);
            String name = rs.getString("name");
            System.out.println("name="+name);
            //}
        }
    }

    private static void m2() throws SQLException {
        try (Connection c = getConnection()) {
            Statement st = c.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = st.executeQuery("select * from person");
            //while(rs.next()){
                //rs.updateString(1, "qqq");
                /*rs.last();
                if(rs.isLast()){
                    System.out.println("last");
                }else{
                    System.out.println("not last");
                }*/
            int row = rs.getRow();
            System.out.println("row="+row);
                boolean res = rs.absolute(3);
                //res = rs.absolute(1);
                System.out.println("res="+res);
                String name = rs.getString("name");
                System.out.println("name="+name);


            //}
        }
    }

    /*private static void m3() throws SQLException {
        try (Connection c = getConnection()) {
            Statement st = c.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = st.executeQuery("select * from person");
            while(rs.next()){
                rs.updateString(1, "qqq");

            }

        }
    }*/

    private static void m1() throws SQLException {
        try (Connection c = getConnection()) {
            DatabaseMetaData meta = c.getMetaData();
            System.out.println("TYPE_FORWARD_ONLY=" + meta.supportsResultSetType(ResultSet.TYPE_FORWARD_ONLY));
            System.out.println("TYPE_SCROLL_SENSITIVE=" + meta.supportsResultSetType(ResultSet.TYPE_SCROLL_SENSITIVE));
            System.out.println("TYPE_SCROLL_INSENSITIVE=" + meta.supportsResultSetType(ResultSet.TYPE_SCROLL_INSENSITIVE));
            System.out.println("--------------------------------");
            System.out.println("CONCUR_READ_ONLY=" + meta.supportsResultSetConcurrency(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY));
            System.out.println("CONCUR_UPDATABLE=" + meta.supportsResultSetConcurrency(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE));

        }
    }

    private static Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/my?useSSL=false", "root", "11111111");
    }

}
