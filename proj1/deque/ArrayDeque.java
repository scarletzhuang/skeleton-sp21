package deque;

import java.util.Iterator;

public class ArrayDeque<T> implements Deque<T>, Iterable<T> {

    private int size;
    private T[] items;
    private int nextFirst;
    private int nextLast;


    public ArrayDeque() {
        this.items = (T[]) new Object[8];
        this.size = 0;
        this.nextFirst = 0;
        this.nextLast = 1;
    }

    @Override
    public void addFirst(T item) {
        if (size == items.length) {
            resize(size * 2);
        }
        items[nextFirst] = item;
        size = size + 1;
        if (nextFirst == 0) {
            nextFirst = items.length - 1;
            return;
        }
        nextFirst = nextFirst - 1;
    }

    @Override
    public void addLast(T item) {
        if (size == items.length) {
            resize(size * 2);
        }
        items[nextLast] = item;
        size = size + 1;
        if (nextLast == items.length - 1) {
            nextLast = 0;
            return;
        }
        nextLast = nextLast + 1;
    }

    @Override
    public int size() {
        return size;
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

        if ((items.length >= 16) && (size < items.length / 4)) {
            resize(items.length / 4);
        }

        int first = getFirstItemIndex();
        T removed = items[first];
        items[first] = null;
        size = size - 1;
        nextFirst = first;
        return removed;
    }

    @Override
    public T removeLast() {
        if (size == 0) {
            return null;
        }

        if ((items.length >= 16) && (size < items.length / 4)) {
            resize(items.length / 4);
        }

        int last = getLastItemIndex();
        T removed = items[last];
        items[last] = null;
        size = size - 1;
        nextLast = last;
        return removed;
    }

    @Override
    public T get(int index) {
        index = getFirstItemIndex() + index;
        if (index >= items.length) {
            index = index - items.length;
        }
        return items[index];
    }

    private void resize(int capacity) {
        T[] a = (T[]) new Object[capacity];

        int p = getFirstItemIndex();
        int end = getLastItemIndex();
        int index = 0;

        do {
            a[index] = items[p];
            p = p + 1;
            if (p == items.length) {
                p = 0;
            }
            index = index + 1;
        } while (p != end);

        a[index] = items[end];

        /* ANOTHER VERSION
        if (first == 0 || last == items.length - 1) {
            System.arraycopy(items, first, a, 0, size);
        } else if (items[0] == null && items[items.length - 1] == null) {
            System.arraycopy(items, first, a, 0, size);
        } else {
            System.arraycopy(items, first, a, 0, items.length - first);
            System.arraycopy(items, 0, a, items.length - first - 1, last + 1);
        }*/

        items = a;
        nextFirst = capacity - 1;
        nextLast = size;
    }

    private int getFirstItemIndex() {
        return nextFirst == items.length - 1 ? 0 : nextFirst + 1;
    }

    private int getLastItemIndex() {
        return nextLast == 0 ? items.length - 1 : nextLast - 1;
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
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }

        if (o == this) {
            return true;
        }

        if (!(o instanceof ArrayDeque)) {
            return false;
        }

        ArrayDeque<T> otherDeque = (ArrayDeque<T>) o;

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
    public Iterator<T> iterator() {
        return new ArrayDequeIterator();
    }

    private class ArrayDequeIterator implements Iterator<T> {
        private int curPos = getFirstItemIndex();
        private int counter = 0;

        @Override
        public boolean hasNext() {
            return counter < size;
        }

        @Override
        public T next() {
            T item = items[curPos];
            curPos = curPos + 1;
            if (curPos == items.length) {
                curPos = 0;
            }
            counter = counter + 1;
            return item;
        }
    }
}
