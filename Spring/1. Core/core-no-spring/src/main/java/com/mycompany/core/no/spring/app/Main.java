/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.core.no.spring.app;

import com.mycompany.core.no.spring.model.Customer;
import com.mycompany.core.no.spring.service.CustomerService;
import com.mycompany.core.no.spring.service.CustomerServiceImpl;
import java.util.List;

/**
 *
 * @author denys
 */
public class Main {
    
    public static void main(String[] args) {
        CustomerService service = new CustomerServiceImpl();
        List<Customer> customers = service.findAll();
        System.out.println(customers);
    }
    
}
