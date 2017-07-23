/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.loading.storing.data;

import javax.cache.Cache;
import javax.cache.CacheManager;
import javax.cache.Caching;
import javax.cache.configuration.MutableConfiguration;
import javax.cache.spi.CachingProvider;

/**
 *
 * @author denys
 */
public class App {

    public static void main(String[] args) throws InterruptedException {
        CachingProvider provider = Caching.getCachingProvider();
        CacheManager cacheManager = provider.getCacheManager();
        MutableConfiguration<Integer, Customer> configuration = Utils.getConfig();
        Cache<Integer, Customer> cache = cacheManager.createCache("names", configuration);
        Customer customer = new Customer();
        customer.setAge(1);
        customer.setName("N1");
        cache.put(1, customer);
        System.out.println("Hello " + cache.get(1));
        Thread.sleep(25000);
        System.out.println("Hello " + cache.get(1));
        provider.close();
    }

}
