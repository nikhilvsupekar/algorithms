package com.data.structures;

import org.junit.Test;

import static org.junit.Assert.*;

public class StackTest {
    @Test
    public void peek() throws Exception {
        Stack<Integer> stack = new Stack<>();

        stack.push(1);
        assertEquals(1, (int)stack.peek());

        stack.push(2);
        assertEquals(2, (int)stack.peek());
    }

    @Test
    public void empty() throws Exception {
        Stack<Integer> stack = new Stack<>();

        assertTrue(stack.isEmpty());

        stack.push(1);
        assertFalse(stack.isEmpty());
    }

    @Test
    public void push() throws Exception {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);

        assertEquals(1, (int)stack.peek());

        stack.push(2);
        assertEquals(2, (int)stack.peek());
    }

    @Test
    public void pop() throws Exception {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);

        assertEquals(1, (int)stack.pop());
        assertTrue(stack.isEmpty());

        stack.push(1);
        stack.push(2);
        stack.pop();
        assertEquals(1, (int)stack.peek());
    }

}