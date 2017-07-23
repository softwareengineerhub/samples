/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.events;

import javax.cache.event.CacheEntryCreatedListener;
import javax.cache.event.CacheEntryEvent;
import javax.cache.event.CacheEntryExpiredListener;
import javax.cache.event.CacheEntryListenerException;
import javax.cache.event.CacheEntryRemovedListener;
import javax.cache.event.CacheEntryUpdatedListener;
import org.loading.storing.data.Customer;

/**
 *
 * @author denys
 */
public class CustomerCacheEntryListener implements
        CacheEntryCreatedListener<Integer, Customer>,
        CacheEntryRemovedListener<Integer, Customer>,
        CacheEntryExpiredListener<Integer, Customer>,
        CacheEntryUpdatedListener<Integer, Customer> {

    @Override
    public void onCreated(Iterable<CacheEntryEvent<? extends Integer, ? extends Customer>> itrbl) throws CacheEntryListenerException {
        System.out.println("onCreated()");
    }

    @Override
    public void onRemoved(Iterable<CacheEntryEvent<? extends Integer, ? extends Customer>> itrbl) throws CacheEntryListenerException {
        System.out.println("onRemoved()");
    }

    @Override
    public void onExpired(Iterable<CacheEntryEvent<? extends Integer, ? extends Customer>> itrbl) throws CacheEntryListenerException {
        System.out.println("onExpired()");
    }

    @Override
    public void onUpdated(Iterable<CacheEntryEvent<? extends Integer, ? extends Customer>> itrbl) throws CacheEntryListenerException {
        System.out.println("onUpdated()");
    }

}
