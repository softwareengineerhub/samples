/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.core.no.spring.app;

import com.mycompany.core.no.spring.repository.CustomerRepository;
import com.mycompany.core.no.spring.repository.JPACustomerRepositoryImpl;
import com.mycompany.core.no.spring.service.CustomerService;
import com.mycompany.core.no.spring.service.CustomerServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author prokopiukd
 */
@Configuration
@ComponentScan({"com.mycompany"})
public class AppConfig {
    
    @Bean(name="customerService")
    public CustomerService getCustomerService(){        
        return new CustomerServiceImpl(getCustomerRepository());
    }
    
    @Bean(name="customerRepository")
    public CustomerRepository getCustomerRepository(){
        return new JPACustomerRepositoryImpl();
    }
    
}
