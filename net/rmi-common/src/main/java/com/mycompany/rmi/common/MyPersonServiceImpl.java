/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.rmi.common;

import java.io.Serializable;

/**
 *
 * @author DProkopiuk
 */
public class MyPersonServiceImpl implements MyPersonService, Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Override
    public MyServiceResponse process(Person person) {
        System.out.println("@@@@@Received person: " + person);
        MyServiceResponse myServiceResponse = new MyServiceResponse();
        if (person.getAge() < 10) {
            myServiceResponse.setStatusCode(401);
            myServiceResponse.setErrorMessage("need to wait");
        } else {
            myServiceResponse.setStatusCode(200);
            myServiceResponse.setErrorMessage("OK");
        }
        return myServiceResponse;
    }

}
