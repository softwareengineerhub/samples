/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.cassandra.client;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;

/**
 *
 * @author denys.prokopiuk
 */
public class CQLSample {

    public static void main(String[] args) {
        Cluster cluster = Cluster.builder().addContactPoint("127.0.0.1").build();
        Session session = cluster.connect();
        System.out.println("----------------------SELECT *----------------------");
        ResultSet rs = session.execute("SELECT count(*) FROM service_data.data_message");
        for (Row row : rs) {
            long count=row.getLong(0);
            System.out.println("count="+count);
        }

        session.close();
        cluster.close();

       /* try (Cluster cluster1 = Cluster.builder().addContactPoint("127.0.0.1").build();
                Session session1 = cluster.connect("my_keyspace");) {

        }*/

    }

}
