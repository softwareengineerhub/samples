/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.repository.cassandra;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.HostDistance;
import com.datastax.driver.core.PoolingOptions;
import com.datastax.driver.core.Session;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Singleton;

/**
 *
 * @author denys.prokopiuk
 */
@Singleton
public class CassandraDataSource {

    private Cluster cluster;
    private Session session;

    @PostConstruct
    private void init() {
        PoolingOptions poolingOptions = new PoolingOptions();
        poolingOptions.setConnectionsPerHost(HostDistance.LOCAL, 10, 100);
        poolingOptions.setMaxRequestsPerConnection(HostDistance.LOCAL, 100);
        poolingOptions.setConnectionsPerHost(HostDistance.REMOTE, 10, 100);
        poolingOptions.setMaxRequestsPerConnection(HostDistance.REMOTE, 100);
        cluster = Cluster.builder().addContactPoint("127.0.0.1").withPoolingOptions(poolingOptions).build();
        session = cluster.connect();

        String cql = "CREATE KEYSPACE IF NOT EXISTS service_data WITH REPLICATION = { 'class' : 'SimpleStrategy', 'replication_factor' : 1  }";
        session.execute(cql);        
        cql = "CREATE TABLE IF NOT EXISTS service_data.data_message("
                + " id UUID,"
                + " status text,"
                + " type text,"
                + " age int,"
                + " name text,"
                + " version text,"
                + "  PRIMARY KEY (id)"
                + ")";
        session.execute(cql);

    }

    public Cluster getCluster() {
        return cluster;
    }

    public Session getSession() {
        return session;
    }

    @PreDestroy
    private void destroy() {
        if (session != null) {
            session.close();
        }
        if (cluster != null) {
            cluster.close();
        }
    }

}
