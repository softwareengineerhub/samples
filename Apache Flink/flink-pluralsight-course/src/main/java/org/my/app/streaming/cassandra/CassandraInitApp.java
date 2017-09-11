/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.my.app.streaming.cassandra;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;

/**
 *
 * @author prokopiukd
 */
public class CassandraInitApp {
    
    public static void main(String[] args) {
        try (Cluster cluster = Cluster.builder().addContactPoint("127.0.0.1").build();) {
            Session session = cluster.connect();
            session.execute("CREATE keyspace IF NOT EXISTS flink_stream_cassandra WITH replication={'class':'SimpleStrategy','replication_factor':1}");
            session.execute("USE flink_stream_cassandra");
            session.execute("CREATE TABLE IF NOT EXISTS persons(name TEXT, age int, PRIMARY KEY ((name),age))");
            session.execute("INSERT INTO persons(name, age) VALUES ('Denis',30)");
            ResultSet rs = session.execute("SELECT * FROM persons");
            for (Row row : rs) {
                String name=row.getString("name");
                int age = row.getInt("age");
                Person p = new Person();
                p.setAge(age);
                p.setName(name);
                System.out.println(p);
            }
        }
    }
    
}
