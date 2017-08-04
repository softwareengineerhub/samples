/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.core.no.spring.service;

import com.mycompany.core.no.spring.model.Customer;
import com.mycompany.core.no.spring.repository.CustomerRepository;
import com.mycompany.core.no.spring.repository.JPACustomerRepositoryImpl;
import java.util.List;

/**
 *
 * @author denys
 */
public class CustomerServiceImpl implements CustomerService {

    private CustomerRepository customerRepository = new JPACustomerRepositoryImpl();

    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

}
