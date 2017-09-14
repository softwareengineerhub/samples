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
public class MySingleLinkedList implements SimpleList {

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
    }

    @Override
    public Object get(int index) {
        if(isEmpty()){
            return null;
        }
        Node tmp = root;
        int i=0;
        while(tmp!=null){
            if(index==i){
                return tmp.getValue();
            }
            tmp = tmp.getNext();
            i++;
        }
        return null;
    }

    @Override
    public Object set(int index, Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void remove(int index) {
        int i=0;
        Node tmp = root;
        while(tmp!=null){
            if(i==index){
                
            }
        }
    }

    @Override
    public boolean isEmpty() {
        return n==0;
    }

    @Override
    public int size() {
        return n;
    }

}
