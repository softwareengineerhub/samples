/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.my.rmi.client;

import com.mycompany.rmi.common.MyPersonService;
import com.mycompany.rmi.common.MyServiceResponse;
import com.mycompany.rmi.common.Person;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author asusadmin
 */
public class ClientApp {
    
    public static void main(String[] args) throws Exception {

        Registry registry = LocateRegistry.getRegistry(1099);
        MyPersonService myPersonServer = (MyPersonService) registry.lookup("//127.0.0.1/MyPersonServer");
        System.out.println("Lookup: "+myPersonServer);


        Person person = new Person();
        person.setName("Name1");
        person.setAge(1);
        MyServiceResponse serviceResponse = myPersonServer.process(person);        
        System.out.println(serviceResponse);
        
        person = new Person();
        person.setName("Name2");
        person.setAge(20);
        serviceResponse = myPersonServer.process(person);        
        System.out.println(serviceResponse);
    }
    
}
