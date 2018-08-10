/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app;

import io.swagger.jaxrs.config.BeanConfig;
import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author denys.prokopiuk
 */
@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application {

    public ApplicationConfig() {
        /*BeanConfig beanConfig = new BeanConfig();
        beanConfig.setVersion("1.0.2");
        beanConfig.setSchemes(new String[]{"http"});
        beanConfig.setHost("localhost:8080");
        beanConfig.setBasePath("/api");
        beanConfig.setResourcePackage("io.swagger.resources");
        beanConfig.setScan(true);*/
    }
    
    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        resources.add(io.swagger.jaxrs.listing.ApiListingResource.class);
        resources.add(io.swagger.jaxrs.listing.SwaggerSerializers.class);
        addRestResourceClasses(resources);
        
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(com.app.GenericResource.class);
        
    }
    
}
