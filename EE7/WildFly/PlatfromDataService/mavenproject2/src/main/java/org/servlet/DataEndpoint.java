/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.servlet;

import com.mycompany.Dao;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author denys.prokopiuk
 */
@Path("/users")
public class DataEndpoint {

    @Autowired
    private Dao dao;

    @GET
    @Path("/{userId}")
    //  @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public String getUser(@PathParam("userId") String userId) {
           System.out.println("userId="+userId);
           return "Data.dao="+dao;
    }

}
