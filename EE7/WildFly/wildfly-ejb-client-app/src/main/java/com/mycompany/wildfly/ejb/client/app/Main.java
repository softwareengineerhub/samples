/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.wildfly.ejb.client.app;

import java.util.Properties;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author denys.prokopiuk
 */
public class Main {
    
    public static void main(String[] args) throws NamingException {
        Properties props = new Properties();
        props.setProperty("remote.connections", "default");
        props.setProperty("remote.connection.default.host", "localhost");
        props.setProperty("remote.connection.default.port", "8080");
       // props.setProperty("java.naming.factory.initial", "org.jboss.naming.remote.client.InitialContextFactory");
        //props.setProperty("java.naming.provider.url","http-remoting://localhost:8080");
        
        props.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");        
        props.put(Context.INITIAL_CONTEXT_FACTORY, "org.wildfly.naming.client.WildFlyInitialContextFactory");
        InitialContext ctx = new InitialContext(props);
       // Object res=ctx.lookup("java:global/wildfly-server-resources-app-1.0-SNAPSHOT/phoneInfoImpl!com.app.ch01.ejb.stateless.remote.PhoneInfo");
        Object res=ctx.lookup("java:app/wildfly-server-resources-app-1.0-SNAPSHOT/phoneInfoImpl!com.app.ch01.ejb.stateless.remote.PhoneInfo");
        //Object res=ctx.lookup("java:module/phoneInfoImpl!com.app.ch01.ejb.stateless.remote.PhoneInfo");
        //Object res=ctx.lookup("ava:app/wildfly-server-resources-app-1.0-SNAPSHOT/phoneInfoImpl!com.app.ch01.ejb.stateless.remote.PhoneInfo");
        //Object res=ctx.lookup("ava:app/wildfly-server-resources-app-1.0-SNAPSHOT/phoneInfoImpl!com.app.ch01.ejb.stateless.remote.PhoneInfo");
        
        System.out.println("res="+res);
    }
    
}
