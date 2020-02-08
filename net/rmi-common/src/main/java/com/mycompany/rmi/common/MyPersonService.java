/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.rmi.common;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author DProkopiuk
 */
public interface MyPersonService extends Remote {

    public MyServiceResponse process(Person person);

}
