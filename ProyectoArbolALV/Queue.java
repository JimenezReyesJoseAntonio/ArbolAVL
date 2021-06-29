

/******************************************************************************
 *  Compilation:  javac Queue.java
 *  Execution:    java Queue < input.txt
 *  Data files:   http://introcs.cs.princeton.edu/43stack/tobe.txt
 *
 *  A generic queue, implemented using a linked list.
 *
 *  % java Queue < tobe.txt
 *  to be or not to be (2 left on queue)
 *
 ******************************************************************************/

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * The Queue class represents a first-in-first-out (FIFO) queue of
 * generic items. It supports the usual enqueue and dequeue
 * operations, along with methods for peeking at the top item, testing if the
 * queue is empty, getting the number of items in the queue, and iterating
 * over the items in FIFO order.
 * 
 * This implementation uses a singly-linked list with a nested class for
 * linked-list nodes. The enqueue, dequeue, peek,
 * size, and is-empty operations all take constant time
 * in the worst case.
 *
 * @param <Item> the generic type of an item in this queue
 * @author Robert Sedgewick
 * @author Kevin Wayne
 */
public class Queue<Item> implements Iterable<Item> {
    private int n;         // number of elements on queue
    private Node first;    // beginning of queue
    private Node last;     // end of queue

    // helper linked list class
    private class Node {
        private Item item;   // the item in the node
        private Node next;   // reference to next item
    }

    /** Initializes an empty queue. */
    public Queue() {
        first = null;
        last = null;
        n = 0;
    }

    /** Returns true if this queue is empty. */
    public boolean isEmpty() {
        return first == null;
    }

    /** Returns the number of items in this queue. */
    public int size() {
        return n;
    }

    /** Returns the number of items in this queue. */
    public int length() {
        return n;
    }

    /** Returns the item least recently added to this queue. */
    public Item peek() {
        if (isEmpty()) throw new NoSuchElementException("Queue underflow");
        return first.item;
    }

    /** Add the item to the queue. */
    public void enqueue(Item item) {
        Node oldlast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if (isEmpty()) first = last;
        else oldlast.next = last;
        n++;
    }

    /** Removes and returns the item on this queue that was least recently added. */
    public Item dequeue() {
        if (isEmpty()) throw new NoSuchElementException("Queue underflow");
        Item item = first.item;
        first = first.next;
        n--;
        if (isEmpty()) last = null;   // to avoid loitering
        return item;
    }

    /** Returns a string representation of this queue. */
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (Item item : this)
            s.append(item + " ");
        return s.toString();
    }

    /** Returns an iterator that iterates over the items in this queue in FIFO order. */
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    /** an iterator, doesn't implement remove() since it's optional */
    private class ListIterator implements Iterator<Item> {
        private Node current = first;  // node containing current item

        public boolean hasNext() {
            return current != null;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next;
            return item;
        }
    }

    /** Unit tests the Queue data type. 
    public static void main(String[] args) {
        Queue<String> queue = new Queue<String>();
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!item.equals("-")) queue.enqueue(item);
            else if (!queue.isEmpty()) StdOut.print(queue.dequeue() + " ");
        }
        StdOut.println("(" + queue.size() + " left on queue)");
    }*/
}
