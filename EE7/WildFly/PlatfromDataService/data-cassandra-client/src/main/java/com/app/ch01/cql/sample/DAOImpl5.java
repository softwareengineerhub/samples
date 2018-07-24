/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.ch01.cql.sample;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.HostDistance;
import com.datastax.driver.core.PoolingOptions;
import com.datastax.driver.core.ProtocolOptions;
import com.datastax.driver.core.ProtocolVersion;
import com.datastax.driver.core.Session;
import java.util.List;

/**
 *
 * @author denys.prokopiuk
 */
public class DAOImpl5 implements DAO {

    private static final String KEYSPACE_NAME = "my_keyspace";
    private Cluster cluster;
    //private Session session;

    public DAOImpl5() {
        PoolingOptions poolingOptions = new PoolingOptions();
        poolingOptions
                .setCoreConnectionsPerHost(HostDistance.LOCAL, 2)
                .setMaxConnectionsPerHost(HostDistance.LOCAL, 8)
                .setCoreConnectionsPerHost(HostDistance.REMOTE, 1)
                .setMaxConnectionsPerHost(HostDistance.REMOTE, 2);

        cluster = Cluster.builder().addContactPoint("127.0.0.1").withPoolingOptions(poolingOptions).withProtocolVersion(ProtocolVersion.V3).build();
        //cluster = Cluster.builder().addContactPoint("127.0.0.1").build();
        //  session = cluster.connect();
        PoolingOptions options = cluster.getConfiguration().getPoolingOptions();
        int core = options.getCoreConnectionsPerHost(HostDistance.LOCAL);
        int max = options.getMaxConnectionsPerHost(HostDistance.LOCAL);
        System.out.println("Local->" + core + ";" + max);
        core = options.getCoreConnectionsPerHost(HostDistance.REMOTE);
        max = options.getMaxConnectionsPerHost(HostDistance.REMOTE);
        System.out.println("Remote->" + core + ";" + max);
        ProtocolOptions protocolOptions = cluster.getConfiguration().getProtocolOptions();
        System.out.println("ProtocolOptions:" + protocolOptions.getProtocolVersion());
    }

    @Override
    public void create(User user) {
        try (Session session = cluster.connect();) {
            String cql = String.format("INSERT INTO my_keyspace.users(login, content, role) VALUES('%s','%s','%s')", user.getLogin(), user.getContent(), user.getRole());
            session.execute(cql);
        }
    }

    @Override
    public void createSchema() {
        try (Session session = cluster.connect();) {
            String cql = "CREATE KEYSPACE IF NOT EXISTS  my_keyspace WITH REPLICATION = { 'class' : 'SimpleStrategy', 'replication_factor' : 1  }";
            session.execute(cql);
        }
    }

    @Override
    public void createTable() {
        try (Session session = cluster.connect();) {
            String cql = "CREATE TABLE IF NOT EXISTS my_keyspace.users(login text, content text, role text,  PRIMARY KEY (login))";
            session.execute(cql);
        }
    }

    @Override
    public void dropSchema() {
        try (Session session = cluster.connect();) {
            String cql = "DROP KEYSPACE IF EXISTS my_keyspace";
            session.execute(cql);
        }
    }

    @Override
    public List<User> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public User find(String login) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public long count() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public User update(String login, User candidateUser) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void remove(String login) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void dropTable() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
