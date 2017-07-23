/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.loading.storing.data;

import java.util.Collection;
import java.util.Map;
import javax.cache.Cache;
import javax.cache.integration.CacheWriter;
import javax.cache.integration.CacheWriterException;

/**
 *
 * @author denys
 */
public class CustomersCacheWriter implements CacheWriter<Integer, Customer> {

    private Map<Integer, Customer> customersRepository;

    public CustomersCacheWriter(Map<Integer, Customer> customersRepository) {
        this.customersRepository = customersRepository;
    }

    @Override
    public void write(Cache.Entry<? extends Integer, ? extends Customer> entry) throws CacheWriterException {        
        customersRepository.put(entry.getKey(), entry.getValue());
    }

    @Override
    public void writeAll(Collection<Cache.Entry<? extends Integer, ? extends Customer>> clctn) throws CacheWriterException {
        for (Cache.Entry<? extends Integer, ? extends Customer> item : clctn) {
            customersRepository.put(item.getKey(), item.getValue());
        }
    }

    @Override
    public void delete(Object o) throws CacheWriterException {
        customersRepository.remove((Integer) o);
    }

    @Override
    public void deleteAll(Collection<?> clctn) throws CacheWriterException {
        for (Object obj : clctn) {
            customersRepository.remove((Integer) obj);
        }
    }

}
