//Ali Sbeih 2/25/2022

//A SimpleDeque implementation that uses a doubly linked list.

public class DLLDeque<E> implements SimpleDeque<E>{
    //The current size of the list
    private int size = 0;

    //The first node in the list (or null if the list is empty).
    private Node<E> head = null;
    //The last node in the list (or null if the list is empty).
    private Node<E> tail = null;

    //Get the current size of the deque
    @Override
    public int size() {
        return this.size;
    }

    //Determine if the deque is currently empty
    @Override
    public boolean isEmpty() {
        return head == null;
    }

    //Add a new element x to the front of the deque.
    @Override
    public void addFirst(E x) {
        // make a new Node to store x
        Node<E> nd = new Node<E>();
        nd.value = x;

        // the newly added item is stored at the head
        nd.next = this.head;
        if(size!=0)head.previous = nd;
        this.head = nd;
        ++size;
    }

    /**
     * Remove and return the element at the front of the deque, if the
     * deque is not empty. If the deque is empty, an
     * EmptyStackException is thrown.
     */
    public E removeFirst() {
        // upon removing the head node, update the head
        E value = head.value;
        head = head.next;
        //head.previous = null;
        --size;
        return value;
    }

    /**
     * Return the element currently at the front of the deque, or
     * null if the deque is empty. The state of the deque
     * is unchanged after this operation.
     */
    @Override
    public E peekFirst() {
        return head.value;
    }

    /**
     * Add a new element x to back of the deque.
     */
    @Override
    public void addLast(E x) {
        // make a new Node to store x
        Node<E> nd = new Node<E>();
        nd.value = x;

        // the newly added item is stored at the tail
        nd.previous = this.tail;
        if(size!=0)tail.next = nd;
        this.tail = nd;
        ++size;
    }

    /**
     * Remove and return the element at the back of the deque, if the
     * deque is not empty. If the deque is empty, an
     * EmptyStackException is thrown.
     */
    @Override
    public E removeLast() {
        // upon removing the tail node, update the tail
        E value = tail.value;
        tail = tail.previous;
        //if(size!=0)tail.next = null;
        --size;
        return value;
    }

    /**
     * Return the element currently at the back of the deque, or
     * null if the deque is empty. The state of the deque
     * is unchanged after this operation.
     */
    @Override
    public E peekLast() {
        return tail.value;
    }


    /**
     * An inner class representing a node in the linked list. Each
     * node stores a reference to an element as well as a reference
     * to the next and previous nodes in the list.
     */
    private class Node<E> {
        Node<E> next;
        Node<E> previous;
        E value;
    }
}
