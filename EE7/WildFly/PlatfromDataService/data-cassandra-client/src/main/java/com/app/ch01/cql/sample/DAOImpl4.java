/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.ch01.cql.sample;

import com.datastax.driver.core.BoundStatement;
import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.HostDistance;
import com.datastax.driver.core.PoolingOptions;
import com.datastax.driver.core.PreparedStatement;
import com.datastax.driver.core.ProtocolOptions;
import com.datastax.driver.core.ProtocolVersion;
import com.datastax.driver.core.Session;
import java.util.List;

/**
 *
 * @author denys.prokopiuk
 */
public class DAOImpl4 implements DAO {

    private static final String KEYSPACE_NAME = "my_keyspace";
    private Cluster cluster;
    private Session session;
    //private PreparedStatement prepared;

    public DAOImpl4() {
        PoolingOptions poolingOptions = new PoolingOptions();
        poolingOptions
                .setCoreConnectionsPerHost(HostDistance.LOCAL, 10)
                .setMaxConnectionsPerHost(HostDistance.LOCAL, 100)
                .setCoreConnectionsPerHost(HostDistance.REMOTE, 10)
                .setMaxConnectionsPerHost(HostDistance.REMOTE, 100);
        //poolingOptions.setMaxRequestsPerConnection(HostDistance.LOCAL, 1000);
        //poolingOptions.setMaxRequestsPerConnection(HostDistance.REMOTE, 1000);
        
        cluster = Cluster.builder().addContactPoint("127.0.0.1").withPoolingOptions(poolingOptions).build();
        //cluster = Cluster.builder().addContactPoint("127.0.0.1").build();
        session = cluster.connect();
        PoolingOptions options = cluster.getConfiguration().getPoolingOptions();
        int core=options.getCoreConnectionsPerHost(HostDistance.LOCAL);
        int max=options.getMaxConnectionsPerHost(HostDistance.LOCAL);
        System.out.println("Local->"+core+";"+max);
        core=options.getCoreConnectionsPerHost(HostDistance.REMOTE);
        max=options.getMaxConnectionsPerHost(HostDistance.REMOTE);
        System.out.println("Remote->"+core+";"+max);
        ProtocolOptions protocolOptions = cluster.getConfiguration().getProtocolOptions();
        System.out.println("ProtocolOptions:"+protocolOptions.getProtocolVersion());
     //   prepared = session.prepare("insert into my_keyspace.users(login, content, role) values (?, ?, ?)");
    }

    @Override
    public void create(User user) {
        PreparedStatement prepared = session.prepare("insert into my_keyspace.users(login, content, role) values (?, ?, ?)");
        BoundStatement bound = prepared.bind(user.getLogin(), user.getContent(), user.getRole());
        session.executeAsync(bound);
        
        //String cql = String.format("INSERT INTO my_keyspace.users(login, content, role) VALUES('%s','%s','%s')", user.getLogin(), user.getContent(), user.getRole());
        //session.execute(cql);
    }

    @Override
    public void createSchema() {
        String cql = "CREATE KEYSPACE IF NOT EXISTS  my_keyspace WITH REPLICATION = { 'class' : 'SimpleStrategy', 'replication_factor' : 1  }";
        session.execute(cql);
    }

    @Override
    public void createTable() {
        String cql = "CREATE TABLE IF NOT EXISTS my_keyspace.users(login text, content text, role text,  PRIMARY KEY (login))";
        session.execute(cql);
    }

    @Override
    public void dropSchema() {
        String cql = "DROP KEYSPACE IF EXISTS my_keyspace";
        session.execute(cql);
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
        String cql = "SELECT COUNT(*) FROM my_keyspace.users";
        return session.execute(cql).one().getLong(0);
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

    }

}
