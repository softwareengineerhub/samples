/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.cassandra.client;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;

/**
 *
 * @author denys.prokopiuk
 */
public class CreateCasespace {

    public static void main(String[] args) {
        try (Cluster cluster = Cluster.builder().addContactPoint("127.0.0.1").build();
                Session session = cluster.connect()) {
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
    }

}
