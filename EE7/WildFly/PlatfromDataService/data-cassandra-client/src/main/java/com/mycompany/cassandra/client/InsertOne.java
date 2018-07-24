/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.cassandra.client;

import com.app.model.Attributes;
import com.app.model.DataMessage;
import com.app.model.Person;
import com.datastax.driver.core.BoundStatement;
import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.PreparedStatement;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;
import com.datastax.driver.core.utils.UUIDs;

/**
 *
 * @author denys.prokopiuk
 */
public class InsertOne {

    public static void main(String[] args) {
        try (Cluster cluster = Cluster.builder().addContactPoint("127.0.0.1").build();
                Session session = cluster.connect();) {
            PreparedStatement preparedStatement = session.prepare("INSERT INTO service_data.data_message (id, status, type, age, name, version) values(?,?,?,?,?,?)");

            Attributes attributes = new Attributes();
            attributes.setStatus("status1");
            attributes.setType("type1");
            Person person = new Person();
            person.setAge(1);
            person.setName("Name1");
            DataMessage dataMessage = new DataMessage();
            dataMessage.setVersion("version1");
            dataMessage.setPerson(person);
            dataMessage.setAttributes(attributes);

            BoundStatement bound = preparedStatement.bind(UUIDs.timeBased(), dataMessage.getVersion(), attributes.getStatus(), attributes.getType(), person.getAge()+"", person.getName());
            session.execute(bound);
            
            ResultSet rs = session.execute("SELECT count(*) FROM service_data.data_message");
            for (Row row : rs) {
                long count = row.getLong(0);
                System.out.println("count=" + count);
            }

        }
    }

}
