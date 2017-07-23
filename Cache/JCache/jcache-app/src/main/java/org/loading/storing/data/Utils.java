/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.loading.storing.data;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.cache.configuration.MutableConfiguration;
import javax.cache.expiry.Duration;
import javax.cache.expiry.TouchedExpiryPolicy;

/**
 *
 * @author denys
 */
public class Utils {
    private static Map<Integer, Customer> dataMap = new HashMap<>();

    public static Map<Integer, Customer> getDataMap() {
        return dataMap;
    }
    
    public static MutableConfiguration<Integer, Customer> getConfig(){
        MutableConfiguration<Integer, Customer> config = new MutableConfiguration<>();
        config.setTypes(Integer.class, Customer.class);
        config.setCacheWriterFactory(new CustomerCacheWriterFactory());        
        config.setWriteThrough(true);
        config.setCacheLoaderFactory(new CustomerCacheLoaderFactory());
        config.setExpiryPolicyFactory(TouchedExpiryPolicy.factoryOf(new Duration(TimeUnit.SECONDS, 20)));
        return config;
    }
    
    
    
}
