/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.loading.storing.data;

import javax.cache.configuration.Factory;

/**
 *
 * @author denys
 */
public class CustomerCacheWriterFactory implements Factory<CustomersCacheWriter> {

    @Override
    public CustomersCacheWriter create() {
        return new CustomersCacheWriter(Utils.getDataMap());
    }
    
}
