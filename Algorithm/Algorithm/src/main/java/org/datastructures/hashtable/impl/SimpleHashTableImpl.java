/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.datastructures.hashtable.impl;

import org.datastructures.hashtable.SimpleHashTable;

/**
 *
 * @author prokopiukd
 */
public class SimpleHashTableImpl<K, V> implements SimpleHashTable<K, V> {

    private Node[] data;
    private int capacity = 40;
    private int n;

    public SimpleHashTableImpl() {
        data = new Node[capacity];
    }

    public SimpleHashTableImpl(int capacity) {
        this.capacity = capacity;
        data = new Node[capacity];
    }

    @Override
    public void put(K key, V value) {
        if (key == null) {
            return;
        }
        int hashIndex = calculateHashIndex(key);
        Node root = data[hashIndex];
        if (root == null) {
            data[hashIndex] = new Node(key, value);
            n++;
            return;
        }
        while (root != null) {
            if (root.getKey().equals(key)) {
                root.setValue(value);
                return;
            }
            root = root.getNext();
        }
        root.setNext(new Node(key, value));
        n++;
    }

    @Override
    public V get(K key) {
        int hashIndex = calculateHashIndex(key);
        Node node = data[hashIndex];
        while (node != null) {
            if (node.getKey().equals(key)) {
                return (V) node.getValue();
            }
        }
        return null;
    }

    @Override
    public K[] keysSet() {
        Object[] keys = new Object[n];
        int i = 0;
        for (Node node : data) {
            while (node != null) {
                keys[i++] = node.getKey();
                node = node.getNext();
            }
        }
        return (K[]) keys;
    }

    @Override
    public void remove(K key) {
        int hashIndex = calculateHashIndex(key);
        Node node = data[hashIndex];
        Node prevNode = null;
        while (node != null) {
            if (node.getKey().equals(key)) {
                if (prevNode != null) {
                    prevNode.setNext(node.getNext());
                } else if (node.getNext() != null) {
                    data[hashIndex] = node.getNext();
                } else {
                    data[hashIndex] = null;
                }
                n--;
                return;
            }
            prevNode = node;
            node = node.getNext();
        }
    }

    @Override
    public boolean isEmpty() {
        return n == 0;
    }

    @Override
    public int size() {
        return n;
    }

    private int calculateHashIndex(Object key) {
        int hash = key.hashCode();
        return hash % capacity;
    }

}
