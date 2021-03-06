/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.core.no.spring.app;

import com.mycompany.core.no.spring.model.Customer;
import com.mycompany.core.no.spring.model.Employee;
import com.mycompany.core.no.spring.model.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author denys
 */
public class Main {
    
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");
        Customer c = ctx.getBean(Customer.class);
        System.out.println(c);
        
        Employee emp = ctx.getBean(Employee.class);
        System.out.println(emp);
        
        Person person = ctx.getBean(Person.class);
        System.out.println(person);
    }
    
}
