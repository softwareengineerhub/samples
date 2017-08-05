/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.core.no.spring.repository;

import com.mycompany.core.no.spring.model.Customer;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author denys
 */
@Repository
public class JPACustomerRepositoryImpl implements CustomerRepository {
    
    @Override
    public List<Customer> findAll(){
        List<Customer> customers = new ArrayList();
        Customer customer = new Customer();
        customer.setFirstname("Denis");
        customer.setLastname("Prokopiuk");
        customers.add(customer);
        return customers;
    }
    
}
