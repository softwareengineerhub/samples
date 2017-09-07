/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.remoteclient;

import com.rainy.hills.VolumeProcessor;
import java.util.Properties;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import org.jboss.naming.remote.client.InitialContextFactory;

/**
 *
 * @author Denis
 */
public class Client {

    public static void main(String[] args) throws Exception {
        Properties jndiProperties = new Properties();
        jndiProperties.put(Context.INITIAL_CONTEXT_FACTORY, "org.jboss.naming.remote.client.InitialContextFactory");
        jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
        jndiProperties.put(Context.PROVIDER_URL, "http-remoting://127.0.0.1:8080/");
        //This property is important for remote resolving
        jndiProperties.put("jboss.naming.client.ejb.context", true);
        //This propert is not important for remote resolving
        jndiProperties.put("org.jboss.ejb.client.scoped.context", "true");
        Context context = new InitialContext(jndiProperties);
        //VolumeProcessor volumeProcessor = (VolumeProcessor) context.lookup("/rainy-hills-app-ear-1.0-SNAPSHOT/rainy-hills-app-ejb-1.0-SNAPSHOT/TheatreInfo!com.rainy.hills.VolumeProcessor");
        VolumeProcessor volumeProcessor = (VolumeProcessor) context.lookup("/rainy-hills-app-ear-1.0-SNAPSHOT/rainy-hills-app-ejb-1.0-SNAPSHOT/VolumeProcessorImpl!com.rainy.hills.VolumeProcessor");
        int[] data = {3, 2, 4, 1, 2};
        int res = volumeProcessor.calculateVolume(data);
        System.out.println("res=" + res);
    }

}
