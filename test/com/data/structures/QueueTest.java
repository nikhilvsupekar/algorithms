package com.data.structures;

import org.junit.Test;

import static org.junit.Assert.*;

public class QueueTest {
    @Test
    public void isEmpty() throws Exception {
        Queue<Integer> queue = new Queue<>();
        assertTrue(queue.isEmpty());

        queue.enqueue(1);
        assertFalse(queue.isEmpty());

        queue.dequeue();
        assertTrue(queue.isEmpty());
    }

    @Test
    public void enqueue() throws Exception {
        Queue<Integer> queue = new Queue<>();
        queue.enqueue(1);
        assertEquals(1, (int)queue.peek());

        queue.enqueue(2);
        queue.enqueue(3);
        assertEquals(1, (int)queue.peek());
    }

    @Test
    public void dequeue() throws Exception {
        Queue<Integer> queue = new Queue<>();
        queue.enqueue(1);
        assertEquals(1, (int)queue.dequeue());

        queue.enqueue(2);
        queue.enqueue(3);
        assertEquals(2 ,(int)queue.dequeue());
        assertEquals(3 ,(int)queue.dequeue());
    }

    @Test
    public void peek() throws Exception {
        Queue<Integer> queue = new Queue<>();
        queue.enqueue(1);
        assertEquals(1, (int)queue.peek());

        queue.enqueue(2);
        queue.enqueue(3);
        assertEquals(1, (int)queue.peek());
    }

}