/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.datastructures.queue;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Denis
 */
public class QueueTest {
    private List<Integer> queueData;
    private Queue<Integer> queue;

    @Before
    public void setUp() {
        queueData = new ArrayList();
        for (int i = 0; i < 16; i++) {
            queueData.add(i);
        }
        queue = new Queue();
    }

    @Test
    public void isEmpty() {
        assertTrue(queue.isEmpty());
        for (Integer item : queueData) {
            queue.enqueue(item);
            assertFalse(queue.isEmpty());
        }
        assertFalse(queue.isEmpty());
    }

    @Test
    public void size() {
        assertTrue(queue.size() == 0);
        int i = 0;
        for (Integer item : queueData) {
            queue.enqueue(item);
            assertTrue(queue.size() == ++i);
        }
        assertTrue(queue.size() == queueData.size());
    }

    @Test
    public void enqueue() {
        for (Integer item : queueData) {
            queue.enqueue(item);
        }
        int i = 0;
        assertTrue(queue.size() == queueData.size());
        for (Integer item : queue) {
            int expectedItem = queueData.get(i);
            assertSame(item, expectedItem);
            i++;
        }
    }

    @Test(expected = NoSuchElementException.class)
    public void dequeue() {
        for (Integer item : queueData) {
            queue.enqueue(item);
        }
        assertTrue(queue.size() == queueData.size());
        for (int i = 0; i < queueData.size(); i++) {
            int expectedItem = queueData.get(queueData.size() - 1 - i);
            assertSame(queue.dequeue(), expectedItem);
        }
        assertTrue(queue.isEmpty());
        queue.dequeue();
    }

}
