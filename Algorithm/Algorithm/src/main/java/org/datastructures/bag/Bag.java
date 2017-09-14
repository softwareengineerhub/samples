/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.datastructures.bag;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

/**
 *
 * @author Denis
 */
public class Bag<T> implements Iterable<T> {

    private Object[] data;
    private int n;
    private final int CAPACITY = 10;
    private long version;

    public Bag() {
        data = new Object[CAPACITY];
    }

    public void add(T item) {
        if (n + 1 > data.length) {
            Object[] tmp = new Object[data.length + CAPACITY];
            System.arraycopy(data, 0, tmp, 0, data.length);
            data = tmp;
        }
        data[n++] = item;
        version++;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public int size() {
        return n;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int n;
            long version = Bag.this.version;

            @Override
            public boolean hasNext() {
                return n < size();
            }

            @Override
            public T next() {
                if (version != Bag.this.version) {
                    throw new ConcurrentModificationException(String.format("Iterator version=%s, but Class version=%s", n, Bag.this.n));
                }
                return (T) data[n++];
            }
        };
    }

}
