/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.annotations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Denis
 */
public class AddressRepository {

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AddressRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void add(int id, Address address) {
        System.out.println("Put to Repository");
        try (Connection c = getConnection()) {
            PreparedStatement ps = c.prepareStatement("INSERT INTO address SET title=?");
            ps.setString(1, address.getTitle());
            ps.execute();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    public void remove(int id) {
        System.out.println("Remove from Repository");
        try (Connection c = getConnection()) {
            PreparedStatement ps = c.prepareStatement("DELETE FROM address WHERE id=?");
            ps.setInt(1, id);
            ps.execute();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    public Address get(int id) {
        System.out.println("Get from Repository");
        try (Connection c = getConnection()) {
            PreparedStatement ps = c.prepareStatement("SELECT * FROM address WHERE id=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Address address = new Address();
                address.setTitle(rs.getString("title"));
                return address;
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return null;
    }

    public void clear() {
        System.out.println("Remove all from Repository");
        try (Connection c = getConnection()) {
            PreparedStatement ps = c.prepareStatement("DELETE FROM address");
            ps.execute();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    public Map<Integer, Address> getData() {
        System.out.println("GetData from Repository");
        Map<Integer, Address> map = new HashMap();
        try (Connection c = getConnection()) {
            PreparedStatement ps = c.prepareStatement("SELECT * FROM address");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Address address = new Address();
                address.setTitle(rs.getString("title"));
                map.put(rs.getInt("id"), address);
            }
            return map;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/my_jpa", "root", "ManchesterCity15");
    }

}
