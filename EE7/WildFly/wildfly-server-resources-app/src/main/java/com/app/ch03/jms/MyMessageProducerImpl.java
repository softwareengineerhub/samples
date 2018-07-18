/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.ch03.jms;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.Session;

/**
 *
 * @author denys.prokopiuk
 */
@Stateless
public class MyMessageProducerImpl implements MyMessageProducer {

    @Resource(name = "InVmConnectionFactory")
    private ConnectionFactory connectionFactory;
    @Resource(name = "java:/jms/queue/DLQ")
    private Destination destination;

    @Override
    public void sendMessage(int salary, boolean active, String type) {
        try {
            Connection c = connectionFactory.createConnection();
            Session session = c.createSession();
            Message msg = session.createTextMessage("Hello");
            msg.setIntProperty("salary", salary);
            msg.setBooleanProperty("active", active);
            msg.setStringProperty("type", type);
            MessageProducer messageProducer = session.createProducer(destination);
            messageProducer.send(msg);
            System.out.println("Message was sent");
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

}
