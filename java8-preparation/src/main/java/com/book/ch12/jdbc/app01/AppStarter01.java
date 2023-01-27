package com.book.ch12.jdbc.app01;

import java.sql.*;

public class AppStarter01 {

    public static void main(String[] args) throws SQLException {
        m5();
    }

    private static void m5() throws SQLException {
        try(Connection c = getConnection()){
            Statement st = c.createStatement();
            boolean isRs = st.execute("select * from person");
            System.out.println("isRs="+isRs);
            int updateCount = st.getUpdateCount();
            System.out.println("updateCount="+updateCount);
            ResultSet rs = st.getResultSet();
            ResultSetMetaData meta = rs.getMetaData();
            int columnCount = meta.getColumnCount();
            System.out.println("columnCount="+columnCount);
            System.out.println(meta.getTableName(1));


            while (rs.next()) {
                System.out.println(rs.getString("name"));
                columnCount = meta.getColumnCount();
                System.out.println("columnCount="+columnCount);
            }
        }
    }

    private static void m4() throws SQLException {
        try(Connection c = getConnection()){
            Statement st = c.createStatement();
            boolean isRs = st.execute("insert into person(name, age) values('test', 4)");
            System.out.println("isRs="+isRs);
            int count = st.getUpdateCount();
            System.out.println("count="+count);
            ResultSet rs = st.getResultSet();
            System.out.println("rs="+rs);
        }
    }

    private static void m3() throws SQLException {
        try(Connection c = getConnection()){
            Statement st = c.createStatement();
            boolean isRs = st.execute("delete from person where id=1");
            System.out.println("isRs="+isRs);
            int count = st.getUpdateCount();
            System.out.println("count="+count);
            ResultSet rs = st.getResultSet();
            System.out.println("rs="+rs);
        }
    }

    private static void m2() throws SQLException {
        try(Connection c = getConnection()){
            Statement st = c.createStatement();
            boolean isRs = st.execute("update person set name='update-data' where id=1");
            System.out.println("isRs="+isRs);
            int count = st.getUpdateCount();
            System.out.println("count="+count);
            ResultSet rs = st.getResultSet();
            System.out.println("rs="+rs);
        }
    }

    private static void m1() throws SQLException {
        try(Connection c = getConnection()){
            Statement st = c.createStatement();
            boolean isRs = st.execute("select * from person");
            System.out.println("isRs="+isRs);
            int updateCount = st.getUpdateCount();
            System.out.println("updateCount="+updateCount);
            ResultSet rs = st.getResultSet();
            while (rs.next()) {
                System.out.println(rs.getString("name"));
            }
        }
    }

    private static Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/my", "root", "11111111");
    }

}
