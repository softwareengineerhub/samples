/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.my.h2.embedded.sample;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author asusadmin
 */
public class DaoImpl implements Dao {

    @Override
    public void clear() {
        try(Connection c = getConnection()){
            c.prepareStatement("DELETE FROM persons").execute();
        }catch(Exception ex){
            throw new RuntimeException(ex);
        }
    }

    @Override
    public int size() {
        try(Connection c = getConnection()){
            ResultSet rs = c.prepareStatement("SELECT count(*) FROM persons").executeQuery();
            rs.next();
            return rs.getInt(1);
        }catch(Exception ex){
            throw new RuntimeException(ex);
        }
    }

    @Override
    public List<Person> readAll() {
        try(Connection c = getConnection()){
            List<Person> persons = new ArrayList();
            ResultSet rs = c.prepareStatement("SELECT * FROM persons").executeQuery();
            while(rs.next()){
                int age = rs.getInt("age");
                String name = rs.getString("name");
                Person p = new Person();
                p.setAge(age);
                p.setName(name);
                persons.add(p);
            }
            return persons;
        }catch(Exception ex){
            throw new RuntimeException(ex);
        }
    }

    @Override
    public void remove(String name) {
        try(Connection c = getConnection()){
            PreparedStatement ps = c.prepareStatement("DELETE FROM persons WHERE name=?");
            ps.setObject(1, name);
            ps.execute();
        } catch(Exception ex){
            throw new RuntimeException(ex);
        }
    }

    @Override
    public void add(Person person) {
        try(Connection c = getConnection()){
            PreparedStatement ps = c.prepareStatement("INSERT INTO persons(name, age) VALUES(?,?)");
            ps.setObject(1, person.getName());
            ps.setObject(2, person.getAge());
            ps.execute();
        }catch(Exception ex){
            throw new RuntimeException(ex);
        }
    }

    @Override
    public void addAll(List<Person> persons) {
        try(Connection c = getConnection()){
            c.setAutoCommit(false);
            for(Person p: persons){
                PreparedStatement ps =c.prepareStatement("INSERT INTO persons(name, age) VALUES(?,?)");
                ps.setObject(1, p.getName());
                ps.setObject(2, p.getAge());
                ps.execute();
            }
            c.commit();
        } catch(Exception ex){
            throw new RuntimeException(ex);
        }
    }

    @Override
    public void update(int age, Person candidate) {
        try(Connection c = getConnection()){
            PreparedStatement ps = c.prepareStatement("UPDATE persons set name=?, age=? WHERE age=?");
            ps.setObject(1, candidate.getName());
            ps.setObject(2, candidate.getAge());
            ps.setObject(2, age);
        } catch(Exception ex){
            throw new RuntimeException(ex);
        }
    }
    
    @Override
    public void initSchema() {
        try(Connection c = getConnection()){
            c.setAutoCommit(false);
            c.prepareStatement("CREATE SCHEMA IF NOT EXISTS persons").execute();            
            String sql = readResource("/cretetable.sql");
            c.prepareStatement(sql).execute();       
            c.commit();
        } catch(Exception ex){
            throw new RuntimeException(ex);
        }
    }

    @Override
    public void dropSchema() {
        try(Connection c = getConnection()){
            c.prepareStatement("DROP TABLE IF EXISTS persons").execute();    
            c.prepareStatement("DROP SCHEMA IF EXISTS persons").execute();    
        } catch(Exception ex){
            throw new RuntimeException(ex);
        }
    }
    
    private Connection getConnection() throws SQLException{
        return DriverManager.getConnection("jdbc:h2:file:E:/Soft/h2/personsdb.db", "sa", "");
    }

    private String readResource(String filePath){
        try(InputStream in = getClass().getResourceAsStream(filePath)){
            byte[] data = new byte[in.available()];
            in.read(data);
            return new String(data);
        }catch(Exception ex){
            throw new RuntimeException(ex);
        }
    }
    
}
