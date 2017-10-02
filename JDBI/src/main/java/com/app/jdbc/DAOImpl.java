/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author prokopiukd
 */
public class DAOImpl implements DAO {

    @Override
    public List<Person> getAll() {
        try (Connection c = getConnection()) {
            PreparedStatement ps = c.prepareStatement("SELECT * FROM person");
            ResultSet rs = ps.executeQuery();
            List<Person> persons = new ArrayList();
            while (rs.next()) {
                Person p = new Person();
                p.setAge(rs.getInt("age"));
                p.setName(rs.getString("name"));
                persons.add(p);
            }
            return persons;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/my_jpa","root", "ManchesterCity15");
    }

}
