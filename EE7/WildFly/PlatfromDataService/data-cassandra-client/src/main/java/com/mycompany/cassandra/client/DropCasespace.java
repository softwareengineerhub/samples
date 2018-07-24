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
public class DropCasespace {

    public static void main(String[] args) {
        try (Cluster cluster = Cluster.builder().addContactPoint("127.0.0.1").build();
                Session session = cluster.connect();) {
            System.out.println("----------------------DROP----------------------");
            session.execute("DROP KEYSPACE IF EXISTS service_data");
            System.out.println("----------------------SUCCESS----------------------");
        }
    }

}
