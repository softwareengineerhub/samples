/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app;

import javax.jms.JMSException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author denys
 */
public class ConsumerMain {
    
    public static void main(String[] args) throws JMSException {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/config.xml");
        TemplateConsumer consumer = ctx.getBean("templateConsumer", TemplateConsumer.class);
        String res=consumer.receiveMessage();
        System.out.println(res);
        
    }
    
}
