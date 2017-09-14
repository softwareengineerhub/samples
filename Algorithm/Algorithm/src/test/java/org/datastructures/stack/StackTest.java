/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.datastructures.stack;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

/**
 *
 * @author Denis
 */
public class StackTest {

    private List<Integer> stackData;
    private Stack<Integer> stack;

    @Before
    public void setUp() {
        stackData = new ArrayList();
        for (int i = 0; i < 16; i++) {
            stackData.add(i);
        }
        stack = new Stack();
    }

    @Test
    public void isEmpty() {
        assertTrue(stack.isEmpty());
        for (Integer item : stackData) {
            stack.push(item);
            assertFalse(stack.isEmpty());
        }
        assertFalse(stack.isEmpty());
    }

    @Test
    public void size() {
        assertTrue(stack.size() == 0);
        int i = 0;
        for (Integer item : stackData) {
            stack.push(item);
            assertTrue(stack.size() == ++i);
        }
        assertTrue(stack.size() == stackData.size());
    }

    @Test
    public void push() {
        for (Integer item : stackData) {
            stack.push(item);
        }
        int i = 0;
        assertTrue(stack.size() == stackData.size());
        for (Integer item : stack) {
            int n = stackData.size();
            int expectedItem = stackData.get(n - 1 - i);
            assertSame(item, expectedItem);
            i++;
        }
    }

    @Test(expected = EmptyStackException.class)
    public void peek() {
        for (Integer item : stackData) {
            stack.push(item);
        }
        assertTrue(stack.size() == stackData.size());
        for (int i = 0; i < stackData.size(); i++) {
            int expectedItem = stackData.get(stackData.size() - 1 - i);
            assertSame(stack.pop(), expectedItem);
        }
        assertTrue(stack.isEmpty());
        stack.pop();
    }

}
