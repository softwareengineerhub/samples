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
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author denys
 */
public class Main {
    
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");
        CustomerService service = ctx.getBean("customerService", CustomerService.class);
        List<Customer> customers = service.findAll();
        System.out.println(customers);
        
        CustomerService service1 = ctx.getBean("customerService1", CustomerService.class);
        List<Customer> customers1 = service1.findAll();
        System.out.println(customers1);
        
        CustomerService service2 = ctx.getBean("customerService2", CustomerService.class);
        List<Customer> customers2 = service2.findAll();
        System.out.println(customers2);
        
        CustomerService service3 = ctx.getBean("customerService3", CustomerService.class);
        List<Customer> customers3 = service3.findAll();
        System.out.println(customers3);
        
        CustomerService service4 = ctx.getBean("customerService4", CustomerService.class);
        List<Customer> customers4 = service4.findAll();
        System.out.println(customers4);
    }
    
}
