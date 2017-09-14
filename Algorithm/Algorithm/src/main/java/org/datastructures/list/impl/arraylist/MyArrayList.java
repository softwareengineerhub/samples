/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.datastructures.list.impl.arraylist;

import org.datastructures.list.SimpleList;

/**
 *
 * @author prokopiukd
 */
public class MyArrayList implements SimpleList {

    private Object[] data;
    private int capacity = 10;
    private long version;
    private int n;

    public MyArrayList() {
        data = new Object[capacity];
    }

    @Override
    public void add(Object obj) {
        if (n + 1 > data.length) {
            Object[] tmp = new Object[data.length + capacity];
            System.arraycopy(data, 0, tmp, 0, data.length);
            data = tmp;
        }
        data[n++] = obj;
        version++;
    }

    @Override
    public Object get(int index) {
        return data[index];
    }

    @Override
    public Object set(int index, Object obj) {
        Object oldValue = data[index];
        data[index] = obj;
        version++;
        return oldValue;
    }

    @Override
    public void remove(int index) {
        for (int i = index; i < n - 1; i++) {
            data[i] = data[i + 1];
        }
        data[n - 1] = null;
        n--;
    }

    @Override
    public boolean isEmpty() {
        return n == 0;
    }

    @Override
    public int size() {
        return n;
    }

}
