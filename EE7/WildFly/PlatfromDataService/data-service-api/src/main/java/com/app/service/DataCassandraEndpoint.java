/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.service;

import com.app.model.DataMessage;
import com.app.model.Attributes;
import com.app.model.Person;
import javax.ejb.EJB;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import com.app.notification.producer.NotificationProducer;
import com.app.repository.DataRepository;

/**
 * REST Web Service
 *
 * @author denys.prokopiuk
 */
@Path("/cassandra")
public class DataCassandraEndpoint {

    @EJB(beanName = "cassandraDataRepository")
    private DataRepository dataRepository;
    @EJB
    private NotificationProducer dataNotificationProducer;
    @Inject
    private Event<String> textEvent;

    @PUT
    @Consumes(value = {MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void put(@Valid DataMessage apiMessage) {
        textEvent.fire("@Before put(DataMessasge)." + apiMessage.hashCode());
        dataRepository.persist(apiMessage);
        dataNotificationProducer.emit(apiMessage);
        textEvent.fire("@After put(DataMessasge)" + apiMessage.hashCode());
    }

    @GET
    @Produces(value = {MediaType.APPLICATION_JSON})
    public DataMessage get() {
        textEvent.fire("@Before get()");
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

        textEvent.fire("@After get()" + dataNotificationProducer + "; " + dataRepository);
        return dataMessage;
    }

}
