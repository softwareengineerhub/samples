/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.datastructures.hashtable.impl.tree;

import org.datastructures.hashtable.impl.Node;

/**
 *
 * @author Denys.Prokopiuk
 */
public class TreeBucket<K, V> {

    //private TreeBucket<K, V> parent;
    private TreeBucket<K, V> left;
    private TreeBucket<K, V> right;
    private Node<K, V> value;
    private int n;
    
    public TreeBucket() {
        
    }

    public TreeBucket(Node<K, V> value) {
        this.value = value;
    }

    public V put(Node<K, V> node) {
        if (value == null) {
            this.value=node;
           // root = new TreeBucket<>(node);
            n++;
            return null;
        }
        int originalHashCode = System.identityHashCode(node.getKey());
        TreeBucket tmp = this;
        while (true) {
            if (tmp.value.getKey().equals(node.getKey())) {
                Object oldValue = tmp.value.getValue();
                tmp.value = node;
                return (V) oldValue;
            }
            if (originalHashCode <= System.identityHashCode(tmp.value.getKey())) {
                if (tmp.left == null) {
                    tmp.left = new TreeBucket(node);
                    n++;
                    return null;
                }
                tmp = tmp.left;
            } else {
                if (tmp.right == null) {
                    tmp.right = new TreeBucket(node);
                    n++;
                    return null;
                }
                tmp = tmp.right;
            }
        }
    }

    public V get(K key) {
        TreeBucket tmp = this;
        while (tmp != null) {
            if (tmp.value.getKey().equals(key)) {
                return (V) tmp.value.getValue();
            }
            int originalHashCode = System.identityHashCode(key);
            if (originalHashCode <= System.identityHashCode(tmp.value.getKey())) {
                tmp = tmp.left;
            } else {
                tmp = tmp.right;
            }
        }
        return null;
    }

    public int size() {
        return n;
    }
    
    
    /*@Override
    public String toString(){
        
    }*/

}
