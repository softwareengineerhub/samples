/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;

/**
 *
 * @author prokopiukd
 */
public class DAOImpl implements DAO {

    private DataSource ds;

    public DAOImpl(DataSource ds) {
        this.ds = ds;

    }

    @Override
    public int getCount() {
        try (Connection c = ds.getConnection()) {
            PreparedStatement ps = c.prepareStatement("SELECT COUNT(*) FROM employee");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return -1;
    }

}
