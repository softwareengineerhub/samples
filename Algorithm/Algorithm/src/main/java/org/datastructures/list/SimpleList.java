/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.datastructures.list;

/**
 *
 * @author prokopiukd
 */
public interface SimpleList {

    public void add(Object obj);

    public Object get(int index);

    public Object set(int index, Object obj);

    public void remove(int index);

    public boolean isEmpty();

    public int size();

}
