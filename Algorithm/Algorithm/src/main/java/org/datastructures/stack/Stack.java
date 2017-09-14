/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.datastructures.stack;

import java.util.ConcurrentModificationException;
import java.util.EmptyStackException;
import java.util.Iterator;

/**
 *
 * @author Denis
 */
public class Stack<T> implements Iterable<T> {

    private final int CAPACITY = 10;
    private int n;
    private long version;
    private Object[] data;

    public Stack() {
        data = new Object[CAPACITY];
    }

    public void push(T item) {
        if (n + 1 > data.length) {
            Object[] tmp = new Object[data.length + CAPACITY];
            System.arraycopy(data, 0, tmp, 0, data.length);
            data = tmp;
        }
        data[n++] = item;
        version++;
    }

    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        Object oldValue = data[n - 1];
        data[n - 1] = null;
        n--;
        version++;
        return (T) oldValue;
    }

    public int size() {
        return n;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {

            int n;
            long version = Stack.this.version;

            @Override
            public boolean hasNext() {
                return n < Stack.this.n;
            }

            @Override
            public T next() {
                if (version != Stack.this.version) {
                    throw new ConcurrentModificationException(String.format("Iterator version=%s, but Class version=%s", version, Stack.this.version));
                }
                return (T) data[size() - 1 - n++];
            }
        };
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < n; i++) {
            sb.append(data[i]);
            if (i != n - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

}
