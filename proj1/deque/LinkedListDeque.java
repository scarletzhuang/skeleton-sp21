package deque;

import java.util.Iterator;

public class LinkedListDeque<T> implements Deque<T>, Iterable<T> {
    private class Node {

        public T item;

        public Node prev;

        public Node next;

        public Node(T item, Node prev, Node next) {
            this.item = item;
            this.prev = prev;
            this.next = next;
        }



    }
    private int size;

    private final Node sentinel;

    public LinkedListDeque() {
        sentinel = new Node(null, null, null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void addFirst(T item) {
        sentinel.next.prev = new Node(item, sentinel, sentinel.next);
        sentinel.next = sentinel.next.prev;
        size = size + 1;
    }

    @Override
    public void addLast(T item) {
        sentinel.prev.next = new Node(item, sentinel.prev, sentinel);
        sentinel.prev = sentinel.prev.next;
        size = size + 1;
    }

    @Override
    public void printDeque() {
        System.out.println(this);
    }

    @Override
    public T removeFirst() {
        if (size == 0) {
            return null;
        }

        Node removedNode = sentinel.next;
        removedNode.next.prev = sentinel;
        sentinel.next = removedNode.next;

        size = size - 1;

        return removedNode.item;
    }

    @Override
    public T removeLast() {
        if (size == 0) {
            return null;
        }

        Node removeNode = sentinel.prev;
        removeNode.prev.next = sentinel;
        sentinel.prev = removeNode.prev;

        size = size - 1;

        return removeNode.item;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        Node node = sentinel.next;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node.item;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (o == this) {
            return true;
        }
        if (!(o instanceof LinkedListDeque)) {
            return false;
        }
        LinkedListDeque<T> otherDeque = (LinkedListDeque) o;
        if (otherDeque.size() != this.size()) {
            return false;
        }
        for (int i = 0; i < this.size(); i++) {
            if (!this.get(i).equals(otherDeque.get(i))) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (T item : this) {
            sb.append(item.toString());
            sb.append(" ");
        }
        return sb.toString();
    }

    @Override
    public Iterator<T> iterator() {
        return new LinkedListDequeIterator();
    }

    private class LinkedListDequeIterator implements Iterator<T> {
        private Node curNode = sentinel;
        private int curPos = 0;

        @Override
        public boolean hasNext() {
            return curPos < size;
        }

        @Override
        public T next() {
            curNode = curNode.next;
            curPos = curPos + 1;
            return curNode.item;
        }
    }

    /**
     * Get the item at the given index.
     * If no such item exists returns null.
     * Uses recursion.
     */
    public T getRecursive(int index) {
        return getRecursive(index, sentinel.next);
    }

    /** Get the item at the given index of a certain node. */
    private T getRecursive(int index, Node p) {
        if (index == 0) {
            return p.item;
        }
        return getRecursive(index - 1, p.next);
    }
}
