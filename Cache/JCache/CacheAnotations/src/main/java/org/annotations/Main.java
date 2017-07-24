/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.annotations;

import javax.cache.Cache;
import javax.cache.CacheManager;
import javax.cache.Caching;
import javax.cache.configuration.MutableConfiguration;
import javax.cache.spi.CachingProvider;

/**
 *
 * @author Denis
 */
public class Main {
    
    public static void main(String[] args) {
        CachingProvider provider = Caching.getCachingProvider();
        CacheManager cacheManager = provider.getCacheManager();
        MutableConfiguration<Integer, Address> configuration = new MutableConfiguration<>();
        AddressController controller = new AddressController();
        Address address = new Address();
        address.setTitle("addr1");
        controller.post(1, address);
        
        Address res = controller.get(1);
        System.out.println("res="+res);
        Cache<Integer, Address> cache = cacheManager.getCache("address");
        
        Address address2 = new Address();
        address2.setTitle("addr2");
        cache.put(2, address2);
        System.out.println("Hello " + cache.get(1));
        
        
        provider.close();
    }
    
}
