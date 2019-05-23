/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.datastructures.hashtable.impl.tree;

import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author Denys.Prokopiuk
 */
public class TreeHashTableImplTest {

    @Test
    public void testPutGet() {
        TreeHashTableImpl<Integer, String> tableImpl = new TreeHashTableImpl<>();
        String oldValue = tableImpl.put(1, "A");
        assertNull(oldValue);
        oldValue = tableImpl.put(2, "B");
        assertNull(oldValue);
        oldValue = tableImpl.put(3, "C");
        assertNull(oldValue);
        oldValue = tableImpl.put(4, "D");
        assertNull(oldValue);
        oldValue = tableImpl.put(5, "E");
        assertNull(oldValue);
        oldValue = tableImpl.put(6, "F");
        assertNull(oldValue);
        oldValue = tableImpl.put(7, "G");
        assertNull(oldValue);
        oldValue = tableImpl.put(8, "H");
        assertNull(oldValue);
        oldValue = tableImpl.put(9, "I");
        assertNull(oldValue);
        oldValue = tableImpl.put(10, "J");
        assertNull(oldValue);
        oldValue = tableImpl.put(10, "J1");
        assertNotNull(oldValue);

        String value = tableImpl.get(1);
        assertNotNull(value);
        assertEquals("A", value);
        value = tableImpl.get(2);
        assertNotNull(value);
        assertEquals("B", value);
        value = tableImpl.get(3);
        assertNotNull(value);
        assertEquals("C", value);
        value = tableImpl.get(4);
        assertNotNull(value);
        assertEquals("D", value);
        value = tableImpl.get(5);
        assertNotNull(value);
        assertEquals("E", value);
        value = tableImpl.get(6);
        assertNotNull(value);
        assertEquals("F", value);
        value = tableImpl.get(7);
        assertNotNull(value);
        assertEquals("G", value);
        value = tableImpl.get(8);
        assertNotNull(value);
        assertEquals("H", value);
        value = tableImpl.get(9);
        assertNotNull(value);
        assertEquals("I", value);
        value = tableImpl.get(10);
        assertNotNull(value);
        assertEquals("J1", value);
        assertSame(10, tableImpl.size());

    }

    @Test
    public void testPersonPutGet() {
        TreeHashTableImpl<Person, String> tableImpl = new TreeHashTableImpl<>();
        Person person1 = new Person("Name1", 1);
        Person person2 = new Person("Name2", 1);
        Person person3 = new Person("Name3", 1);
        Person person4 = new Person("Name4", 1);
        Person person5 = new Person("Name5", 1);
        Person person6 = new Person("Name6", 1);
        Person person7 = new Person("Name7", 1);
        
        String oldValue = tableImpl.put(person1, "P1");
        assertNull(oldValue);
        
        oldValue = tableImpl.put(person2, "P2");
        assertNull(oldValue);
        
        oldValue = tableImpl.put(person3, "P3");
        assertNull(oldValue);
        
        oldValue = tableImpl.put(person4, "P4");
        assertNull(oldValue);
        
        oldValue = tableImpl.put(person5, "P5");
        assertNull(oldValue);
        
        oldValue = tableImpl.put(person6, "P6");
        assertNull(oldValue);
        
        oldValue = tableImpl.put(person7, "P7");
        assertNull(oldValue);
        
        assertSame(tableImpl.size(), 7);
        
        String value = tableImpl.get(person1);
        assertEquals("P1", value);
        value = tableImpl.get(person2);
        assertEquals("P2", value);
        value = tableImpl.get(person3);
        assertEquals("P3", value);
        value = tableImpl.get(person4);
        assertEquals("P4", value);
        value = tableImpl.get(person5);
        assertEquals("P5", value);
        value = tableImpl.get(person6);
        assertEquals("P6", value);
        value = tableImpl.get(person7);
        assertEquals("P7", value);
        
        oldValue = tableImpl.put(person7, "P7-test");
        assertNotNull(oldValue);
        assertEquals("P7", oldValue);   
        value = tableImpl.get(person7);
        assertEquals("P7-test", value);
        
    }

}
