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

/**
 *
 * @author Denis
 */
public class AddressRepository {

    private Map<Integer, Address> data = new HashMap();

    public void add(int id, Address address) {
        System.out.println("Put to Repository");
        try (Connection c = getConnection()) {
            PreparedStatement ps = c.prepareStatement("INSERT INTO address SET title=?");
            ps.setString(1, address.getTitle());
            ps.execute();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        //data.put(id, address);
    }

    public void remove(int id) {
        System.out.println("Remove from Repository");
        data.remove(id);
    }

    public Address get(int id) {
        System.out.println("Get from Repository");
        //return data.get(id);
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
        data.clear();
    }

    public Map<Integer, Address> getData() {
        return data;
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/hello", "root", "111111");
    }

}
