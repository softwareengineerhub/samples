/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.datastructures.list.impl.linkedlist;

import org.datastructures.list.SimpleList;
import org.datastructures.list.impl.arraylist.MyArrayList;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Denis
 */
public class MySimpleLinkedListTest {
     private SimpleList simpleList;

    @Before
    public void init() {
        simpleList = new MySimpleLinkedList();
    }

    @Test
    public void size() {
        assertTrue(simpleList.size() == 0);
        simpleList.add(1);
        assertTrue(simpleList.size() == 1);
        for (int i = 0; i < 10; i++) {
            simpleList.add(1);
        }
        assertTrue(simpleList.size() == 11);
    }

    @Test
    public void isEmpty() {
        assertTrue(simpleList.isEmpty());
        simpleList.add(1);
        assertFalse(simpleList.isEmpty());
        for (int i = 0; i < 10; i++) {
            simpleList.add(1);
        }
        assertFalse(simpleList.isEmpty());
    }

    @Test
    public void addGet() {
        simpleList.add(1);
        assertTrue((Integer) simpleList.get(0) == 1);
        for (int i = 0; i < 10; i++) {
            simpleList.add(i);
            assertTrue((Integer) simpleList.get(i + 1) == i);
        }
    }

    @Test
    public void set() {
        simpleList.add(0);
        simpleList.set(0, -1);
        assertTrue((Integer) simpleList.get(0) == -1);
        for (int i = 0; i < 10; i++) {
            simpleList.add(i + 1);
        }

        simpleList.set(5, 50);
        assertTrue((Integer) simpleList.get(5) == 50);

        simpleList.set(simpleList.size() - 1, 100);
        assertTrue((Integer) simpleList.get(simpleList.size() - 1) == 100);
    }
}
