/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.repository.cassandra;

import com.app.model.DataMessage;
import com.app.model.Attributes;
import com.app.model.Person;
import com.app.utils.ResourceReader;
import com.datastax.driver.core.BoundStatement;
import com.datastax.driver.core.PreparedStatement;
import com.datastax.driver.core.Session;
import com.datastax.driver.core.utils.UUIDs;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;
import com.app.repository.DataRepository;

/**
 *
 * @author denys.prokopiuk
 */
@Stateless(name = "cassandraDataRepository")
public class CassandraDataRepositoryImpl implements DataRepository {

    @EJB
    private CassandraDataSource cassandraDataSource;
    @Inject
    private ResourceReader resourceReader;
    private Session session;
    private String cql;
    private PreparedStatement preparedStatement;

    @PostConstruct
    public void init() {
        session = cassandraDataSource.getSession();
        cql = resourceReader.getContent("/cql/cql.txt");
        preparedStatement = session.prepare(cql);
    }

    @Override
    public void persist(DataMessage dataMessage) {
        BoundStatement bound = bound(dataMessage);
        session.execute(bound);
    }

    private BoundStatement bound(DataMessage dataMessage) {
        Attributes attributes = dataMessage.getAttributes();
        Person person = dataMessage.getPerson();
        return preparedStatement.bind(UUIDs.timeBased(), dataMessage.getVersion(), attributes.getStatus(), attributes.getType(), person.getAge()+"", person.getName());
    }

}
