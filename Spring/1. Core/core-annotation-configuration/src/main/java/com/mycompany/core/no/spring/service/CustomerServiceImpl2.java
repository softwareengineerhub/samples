/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.core.no.spring.service;

import com.mycompany.core.no.spring.model.Customer;
import com.mycompany.core.no.spring.repository.CustomerRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author prokopiukd
 */
@Service("customerServiceConstructorInjection")
public class CustomerServiceImpl2 implements CustomerService {

    private CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl2(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

}
