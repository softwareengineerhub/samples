/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.loading.storing.data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.cache.integration.CacheLoader;
import javax.cache.integration.CacheLoaderException;

/**
 *
 * @author denys
 */
public class CustomersCacheLoader implements CacheLoader<Integer, Customer> {
    private Map<Integer, Customer> customersRepository;

    public CustomersCacheLoader(Map<Integer, Customer> customersRepository) {
        this.customersRepository = customersRepository;
    }

    @Override
    public Customer load(Integer k) throws CacheLoaderException {
        System.out.println("load data by key=" + k);
        return customersRepository.get(k);
    }

    @Override
    public Map<Integer, Customer> loadAll(Iterable<? extends Integer> itrbl) throws CacheLoaderException {
        Map<Integer, Customer> map = new HashMap();
        for (int i : itrbl) {
            map.put(i, customersRepository.get(i));
        }
        return map;
    }
    
}
