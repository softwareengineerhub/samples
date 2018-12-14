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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.JoinRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;
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
        try (Connection c = getConnection()) {

            RowSetFactory rsf = RowSetProvider.newFactory();
            CachedRowSet studentRS = rsf.createCachedRowSet();
            studentRS.setCommand("select SID, NAME from STUDENT");

            CachedRowSet enrollmentRS = rsf.createCachedRowSet();
            enrollmentRS.setCommand("select SID, SUBJECT from enrollment");

            CachedRowSet teacherRS = rsf.createCachedRowSet();
            teacherRS.setCommand("select TID, subject from TEACHER");

            studentRS.execute(c);
            enrollmentRS.execute(c);
            teacherRS.execute(c);

            JoinRowSet jrs = rsf.createJoinRowSet();       
            jrs.addRowSet(studentRS, "SID");
            jrs.addRowSet(enrollmentRS, "SID");
         //   jrs.addRowSet(teacherRS, "SUBJECT");

          //  jrs.execute();
          
            ResultSetMetaData meta = jrs.getMetaData();
            int n = meta.getColumnCount();
            List<String> columnNames = new ArrayList();
            for(int i=0;i<n;i++){
                columnNames.add(meta.getColumnName(i+1));
            }           
            while (jrs.next()) {
                for(String column : columnNames){
                    System.out.println(column+"="+jrs.getObject(column));
                }
                System.out.println("---------------------");
                //System.out.println("id=" + jrs.getInt(1));
                //System.out.println("login=" + jrs.getString(2));
                //System.out.println("pass=" + jrs.getString(3));
                //System.out.println("role=" + jrs.getString(4));
                //System.out.println("------------------------------");
            }
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
    
     public void makeCall2() {
        try (Connection c = getConnection()) {

            RowSetFactory rsf = RowSetProvider.newFactory();
            CachedRowSet studentRS = rsf.createCachedRowSet();
            studentRS.setCommand("select * from STUDENT");

            CachedRowSet enrollmentRS = rsf.createCachedRowSet();
            enrollmentRS.setCommand("select * from enrollment");

            CachedRowSet teacherRS = rsf.createCachedRowSet();
            teacherRS.setCommand("select * from TEACHER");

            studentRS.execute(c);
            enrollmentRS.execute(c);
            teacherRS.execute(c);

            JoinRowSet jrs = rsf.createJoinRowSet();       
            jrs.addRowSet(studentRS, "SID");
            jrs.addRowSet(enrollmentRS, "SID");
         //   jrs.addRowSet(teacherRS, "SUBJECT");

          //  jrs.execute();
          
            ResultSetMetaData meta = jrs.getMetaData();
            int n = meta.getColumnCount();
            List<String> columnNames = new ArrayList();
            for(int i=0;i<n;i++){
                columnNames.add(meta.getColumnName(i+1));
            }           
            while (jrs.next()) {
                for(String column : columnNames){
                    System.out.println(column+"="+jrs.getObject(column));
                }
                System.out.println("---------------------");
                //System.out.println("id=" + jrs.getInt(1));
                //System.out.println("login=" + jrs.getString(2));
                //System.out.println("pass=" + jrs.getString(3));
                //System.out.println("role=" + jrs.getString(4));
                //System.out.println("------------------------------");
            }
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb", "root", "111111");
    }

}
