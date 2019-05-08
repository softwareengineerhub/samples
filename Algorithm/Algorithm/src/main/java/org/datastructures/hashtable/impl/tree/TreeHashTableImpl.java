/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.datastructures.hashtable.impl.tree;

import org.datastructures.hashtable.SimpleHashTable;
import org.datastructures.hashtable.impl.Node;

/**
 *
 * @author Denys.Prokopiuk
 */
public class TreeHashTableImpl<K, V> implements SimpleHashTable<K, V> {

    private int n;
    private TreeBucket<K, V>[] buckets;
    private int capacity;

    public TreeHashTableImpl(int capacity) {
        this.capacity = capacity;
        buckets = new TreeBucket[capacity];        
    }

    public TreeHashTableImpl() {
        this(10);
    }

    @Override
    public V put(K key, V value) {
        TreeBucket<K, V> bucket = findBucket(key);
        int oldSize = bucket.size();
        V oldValue = bucket.put(new Node<>(key, value));
        if (bucket.size() > oldSize) {
            n++;
        }
        return oldValue;
    }

    @Override
    public V get(K key) {
        TreeBucket<K, V> bucket = findBucket(key);
        return bucket.get(key);
    }

    @Override
    public K[] keysSet() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void remove(K key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isEmpty() {
        return n == 0;
    }

    @Override
    public int size() {
        return n;
    }

    private TreeBucket<K, V> findBucket(K key) {
        int index = key.hashCode() % capacity;        
        if(buckets[index]==null){
            buckets[index] = new TreeBucket();
        }
        return buckets[index];
    }

}
