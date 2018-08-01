/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.servlet;

/**
 *
 * @author denys.prokopiuk
 */
import com.mycompany.Dao;
import javax.ws.rs.ApplicationPath;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.beans.factory.annotation.Autowired;
 
@ApplicationPath("api")
public class MyApi extends ResourceConfig {
 
    @Autowired
    private Dao dao;
    
}