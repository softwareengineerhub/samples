/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.datastructures.hashtable.impl;

/**
 *
 * @author prokopiukd
 */
public class Node<K, V> {

    private K key;
    private V value;
    private Node next;

    public Node(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public Node() {
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

}
