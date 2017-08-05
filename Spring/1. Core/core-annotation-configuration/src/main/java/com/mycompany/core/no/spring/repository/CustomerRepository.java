/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.core.no.spring.repository;

import com.mycompany.core.no.spring.model.Customer;
import java.util.List;

/**
 *
 * @author denys
 */
public interface CustomerRepository {

    public List<Customer> findAll();

}
