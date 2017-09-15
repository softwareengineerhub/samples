/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.datastructures.hashtable;

/**
 *
 * @author prokopiukd
 */
public interface SimpleHashTable<K, V> {

    public void put(K key, V value);

    public V get(K key);

    public K[] keysSet();

    public void remove(K key);

    public boolean isEmpty();

    public int size();

}
