/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.core.no.spring.app;

import com.mycompany.core.no.spring.model.Customer;
import com.mycompany.core.no.spring.model.Dog;
import com.mycompany.core.no.spring.model.Employee;
import com.mycompany.core.no.spring.model.Person;
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
        Customer c = ctx.getBean(Customer.class);
        System.out.println(c.hashCode());
        Customer c1 = ctx.getBean(Customer.class);
        System.out.println(c1.hashCode());
        
        Employee emp1 = ctx.getBean(Employee.class);
        System.out.println(emp1.hashCode());
        Employee emp2 = ctx.getBean(Employee.class);
        System.out.println(emp2.hashCode());
        
        Person person1 = ctx.getBean(Person.class);
        System.out.println(person1.hashCode());
        Person person2 = ctx.getBean(Person.class);
        System.out.println(person2.hashCode());

        Dog dog1 = ctx.getBean(Dog.class);
        System.out.println(dog1.hashCode());
        Dog dog2 = ctx.getBean(Dog.class);
        System.out.println(dog2.hashCode());
        
        
    }
    
}
