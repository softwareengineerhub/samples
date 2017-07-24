/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.annotations;

import java.util.Map;
import javax.cache.annotation.CacheDefaults;
import javax.cache.annotation.CacheKey;
import javax.cache.annotation.CachePut;
import javax.cache.annotation.CacheRemove;
import javax.cache.annotation.CacheRemoveAll;
import javax.cache.annotation.CacheResult;
import javax.cache.annotation.CacheValue;
import javax.enterprise.context.ApplicationScoped;

/**
 *
 * @author Denis
 */
@CacheDefaults(cacheName = "address")
@ApplicationScoped
public class AddressController {
    
    private AddressRepository repository = new AddressRepository();
    
    @CachePut
    public void post(@CacheKey int id, @CacheValue Address address){
        repository.add(id, address);
    }
    
    @CacheRemove
    public void delete(int id){
        repository.remove(id);
    }
    
    @CacheResult
    public Address get(int id){
        return repository.get(id);
    }
    
    @CacheRemoveAll
    public void clear(){
        repository.clear();
    }
    
    public Map<Integer, Address> getData(){
        return repository.getData();
    }
    
    
}
