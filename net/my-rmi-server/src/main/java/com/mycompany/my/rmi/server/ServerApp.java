/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.my.rmi.server;

import com.mycompany.rmi.common.MyPersonServiceImpl;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author asusadmin
 */
public class ServerApp {
 
    public static void main(String[] args) throws Exception {
        Registry registry = LocateRegistry.createRegistry(1099);
        registry.rebind("//127.0.0.1/MyPersonServer", new MyPersonServiceImpl());
        //Naming.rebind("//127.0.0.1/MyPersonServer", new MyPersonServiceImpl());
        System.err.println("Server ready");
        Thread.sleep(Integer.MAX_VALUE);
    }
    
}
