/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.core.no.spring.app;

import com.mycompany.core.no.spring.model.Customer;
import com.mycompany.core.no.spring.repository.CustomerRepository;
import com.mycompany.core.no.spring.service.CustomerService;
import com.mycompany.core.no.spring.service.CustomerServiceImpl;
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
        
        CustomerService service = ctx.getBean("customerServiceMemberInjection", CustomerService.class);
        List<Customer> customers = service.findAll();
        System.out.println(customers);
        
        CustomerService service1 = ctx.getBean("customerServiceSetterInjection", CustomerService.class);
        List<Customer> customers1 = service1.findAll();
        System.out.println(customers1);
        
        CustomerService service2 = ctx.getBean("customerServiceConstructorInjection", CustomerService.class);
        List<Customer> customers2 = service2.findAll();
        System.out.println(customers2);
        
    }
    
}
