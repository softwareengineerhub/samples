/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.events;

import javax.cache.configuration.FactoryBuilder;
import javax.cache.configuration.MutableCacheEntryListenerConfiguration;
import javax.cache.configuration.MutableConfiguration;
import org.loading.storing.data.Customer;

/**
 *
 * @author denys
 */
public class ListenerUtils {

    public static MutableCacheEntryListenerConfiguration<Integer, Customer> getCacheEntryListener() {
        return new MutableCacheEntryListenerConfiguration<>(
                FactoryBuilder.factoryOf(CustomerCacheEntryListener.class),
                null,
                true,
                true
        );
    }
    
    public static MutableConfiguration<Integer, Customer> getConfiguration(){
        MutableConfiguration<Integer, Customer> config = new MutableConfiguration<>();
        config.setTypes(Integer.class, Customer.class).addCacheEntryListenerConfiguration(getCacheEntryListener());
        return config;
    }
    

}
