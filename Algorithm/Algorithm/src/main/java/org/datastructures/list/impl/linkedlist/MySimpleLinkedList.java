/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.datastructures.list.impl.linkedlist;

import org.datastructures.list.SimpleList;

/**
 *
 * @author prokopiukd
 */
public class MySimpleLinkedList implements SimpleList {

    private Node root;
    private int n;

    @Override
    public void add(Object obj) {
        n++;
        Node node = new Node();
        node.setValue(obj);
        if (root == null) {
            root = node;
            return;
        }
        Node tmp = root;
        while (tmp.getNext() != null) {
            tmp = tmp.getNext();
        }
        tmp.setNext(node);
        node.setPrev(tmp);
    }

    @Override
    public Object get(int index) {
        if (isEmpty()) {
            return null;
        }
        Node tmp = root;
        int i = 0;
        while (tmp != null) {
            if (index == i) {
                return tmp.getValue();
            }
            tmp = tmp.getNext();
            i++;
        }
        return null;
    }

    @Override
    public Object set(int index, Object obj) {
        int i = 0;
        Node tmp = root;
        while (tmp != null && i <= index) {
            if (i == index) {
                Object oldValue = tmp.getValue();
                tmp.setValue(obj);
                return oldValue;
            }
            tmp = tmp.getNext();
            i++;
        }
        return null;
    }

    @Override
    public void remove(int index) {
        int i = 0;
        Node tmp = root;
        while (tmp != null && i <= index) {
            if (i == index) {
                n--;
                Node prev = tmp.getPrev();
                Node next = tmp.getNext();
                if (prev != null && next != null) {
                    prev.setNext(next);
                    next.setPrev(prev);
                    return;
                }
                if (prev == null) {
                    root = next;
                    root.setPrev(null);
                    return;
                }
                if (next == null) {
                    prev.setNext(null);
                }
            }
            tmp = tmp.getNext();
            i++;
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

}
