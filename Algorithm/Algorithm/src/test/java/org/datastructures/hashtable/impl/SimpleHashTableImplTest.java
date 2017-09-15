/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.datastructures.hashtable.impl;

import java.util.Arrays;
import org.datastructures.hashtable.SimpleHashTable;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author prokopiukd
 */
public class SimpleHashTableImplTest {

    private SimpleHashTable hashTable;

    @Before
    public void init() {
        hashTable = new SimpleHashTableImpl();
    }

    @Test
    public void putGet() {
        hashTable.put(100, "A");
        assertTrue(hashTable.size() == 1);
        assertEquals(hashTable.get(100), "A");
        hashTable.put(100, "B");
        assertTrue(hashTable.size() == 1);
        assertEquals(hashTable.get(100), "B");
        for (int i = 0; i < 10; i++) {
            hashTable.put(i, "Value" + i);
        }
        assertTrue(hashTable.size() == 11);
        for (int i = 0; i < 10; i++) {
            assertEquals(hashTable.get(i), "Value" + i);
        }
    }

    @Test
    public void size() {
        assertTrue(hashTable.size() == 0);
        hashTable.put(100, "A");
        assertTrue(hashTable.size() == 1);
        assertEquals(hashTable.get(100), "A");
        hashTable.put(100, "B");
        assertTrue(hashTable.size() == 1);
        assertEquals(hashTable.get(100), "B");
        for (int i = 0; i < 10; i++) {
            hashTable.put(i, "Value" + i);
        }
        assertTrue(hashTable.size() == 11);
    }

    @Test
    public void isEmpty() {
        assertTrue(hashTable.isEmpty());
        hashTable.put(100, "A");
        assertFalse(hashTable.isEmpty());
    }

    @Test
    public void keysSet() {
        assertTrue(hashTable.keysSet().length == 0);
        hashTable.put(100, "A");
        Object[] actual = {100};
        assertTrue(Arrays.equals(hashTable.keysSet(), actual));
        for (int i = 0; i < 10; i++) {
            hashTable.put(i, "Value" + i);
        }
        actual = new Object[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 100};
        assertTrue(Arrays.equals(hashTable.keysSet(), actual));
    }

    @Test
    public void remove() {
        hashTable.put(100, "A");
        hashTable.remove(100);
        assertTrue(hashTable.size() == 0);
        assertNull(hashTable.get(100));
        for (int i = 0; i < 10; i++) {
            hashTable.put(i, "Value" + i);
        }
        assertTrue(hashTable.size() == 10);
        hashTable.remove(5);
        assertTrue(hashTable.size() == 9);
        assertNull(hashTable.get(5));
    }

}
