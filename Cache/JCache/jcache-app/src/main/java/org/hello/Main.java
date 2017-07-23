/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.hello;

import javax.cache.Cache;
import javax.cache.CacheManager;
import javax.cache.Caching;
import javax.cache.configuration.MutableConfiguration;
import javax.cache.spi.CachingProvider;

/**
 *
 * @author denys
 */
public class Main {

    public static void main(String[] args) {
        CachingProvider provider = Caching.getCachingProvider();
        CacheManager cacheManager = provider.getCacheManager();
        MutableConfiguration<Integer, String> configuration = new MutableConfiguration<>();
        Cache<Integer, String> cache = cacheManager.createCache("names", configuration);
        cache.put(1, "JCache");
        System.out.println("Hello " + cache.get(1));
        provider.close();
    }

}
