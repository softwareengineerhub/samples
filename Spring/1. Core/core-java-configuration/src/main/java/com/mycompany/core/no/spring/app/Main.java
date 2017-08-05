/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.core.no.spring.app;

import com.mycompany.core.no.spring.model.Customer;
import com.mycompany.core.no.spring.service.CustomerService;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author denys
 */
public class Main {

    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);

        CustomerService service = ctx.getBean("customerService", CustomerService.class);
        List<Customer> customers = service.findAll();
        System.out.println(customers);
    }

}
