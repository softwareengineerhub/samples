/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.datastructures.bag;

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Denis
 */
public class BagTest {

    private List<Integer> bagData;
    private Bag<Integer> bag;

    @Before
    public void setUp() {
        bagData = new ArrayList();
        for (int i = 0; i < 16; i++) {
            bagData.add(i);
        }
        bag = new Bag();
    }

    @Test
    public void isEmpty() {
        assertTrue(bag.isEmpty());
        for (Integer item : bagData) {
            bag.add(item);
            assertFalse(bag.isEmpty());
        }
        assertFalse(bag.isEmpty());
    }

    @Test
    public void size() {
        assertTrue(bag.size() == 0);
        int i = 0;
        for (Integer item : bagData) {
            bag.add(item);
            assertTrue(bag.size() == ++i);
        }
        assertTrue(bag.size() == bagData.size());
    }

    @Test
    public void add() {
        for (Integer item : bagData) {
            bag.add(item);
        }
        int i = 0;
        assertTrue(bag.size() == bagData.size());
        for (Integer item : bag) {
            assertSame(item, bagData.get(i++));
        }
    }

}
