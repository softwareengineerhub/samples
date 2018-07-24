/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.repository.relational;

import com.app.model.DataMessage;
import com.app.model.Attributes;
import com.app.model.Person;
import com.app.utils.ResourceReader;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.sql.DataSource;
import com.app.repository.DataRepository;
import javax.annotation.Resource;

/**
 *
 * @author denys.prokopiuk
 */
@Stateless(name = "relationalRepository")
public class RelationalDataRepositoryImpl implements DataRepository {

    //@Resource(name = "dataDS")
    private DataSource ds;
    @Inject
    private ResourceReader resourceReader;

    @Override
    public void persist(DataMessage apiMessage) {
        try (Connection c = ds.getConnection()) {
            Attributes attributes = apiMessage.getAttributes();
            Person person = apiMessage.getPerson();
            String sql = resourceReader.getContent("/sql/sql.txt");
            PreparedStatement ps = c.prepareStatement(sql);
            int i = 1;
            ps.setString(i++, attributes.getStatus());
            ps.setString(i++, attributes.getType());
            ps.setInt(i++, person.getAge());
            ps.setString(i++, person.getName());
            ps.setString(i++, apiMessage.getVersion());
            ps.execute();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    @PostConstruct
    private void init() {
        ds = new DataSource() {
            @Override
            public Connection getConnection() throws SQLException {
                return DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/data_db", "root", "111111");
            }

            @Override
            public Connection getConnection(String username, String password) throws SQLException {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public PrintWriter getLogWriter() throws SQLException {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void setLogWriter(PrintWriter out) throws SQLException {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void setLoginTimeout(int seconds) throws SQLException {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public int getLoginTimeout() throws SQLException {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public Logger getParentLogger() throws SQLFeatureNotSupportedException {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public <T> T unwrap(Class<T> iface) throws SQLException {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public boolean isWrapperFor(Class<?> iface) throws SQLException {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        };
    }

}
