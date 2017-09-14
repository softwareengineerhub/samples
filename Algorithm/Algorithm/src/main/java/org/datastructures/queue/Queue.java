/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.datastructures.queue;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.LinkedList;

/**
 *
 * @author Denis
 */
public class Queue<T> implements Iterable<T> {

    private LinkedList<T> data;
    private long version;

    public Queue() {
        data = new LinkedList();
    }

    public void enqueue(T item) {
        data.add(item);
    }

    public T dequeue() {
        return data.removeLast();
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }

    public int size() {
        return data.size();
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int n;
            long version = Queue.this.version;

            @Override
            public boolean hasNext() {
                return n < data.size();
            }

            @Override
            public T next() {
                if (version != Queue.this.version) {
                    throw new ConcurrentModificationException(String.format("Iterator version=%s, but Class version=%s", version, Queue.this.version));
                }
                return data.get(n++);
            }
        };
    }

}
