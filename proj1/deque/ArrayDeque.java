package deque;

public class ArrayDeque<T> implements Deque<T> {

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

    private void resize(int capacity) {
        T[] array = (T[]) new Object[capacity];
        int first = getFirstItemIndex();
        System.arraycopy(items, first, array, 0, size - first);
        System.arraycopy(items, 0, array, size - first, first);
        items = array;
        nextFirst = capacity - 1;
        nextLast = size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void printDeque() {
        String result = "";
        int index = getFirstItemIndex();
        for (int i = 0; i < size; i++) {
            result = result + " " + items[index];
            index = index + 1;
            if (index == items.length) {
                index = 0;
            }
        }
        System.out.println(result);
    }

    @Override
    public T removeFirst() {
        if (size == 0) {
            return null;
        }

        if ((items.length >= 16) && (size < items.length / 4) ) {
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

        if ((items.length >= 16) && (size < items.length / 4) ) {
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

    private int getFirstItemIndex() {
        return nextFirst == items.length - 1 ? 0 : nextFirst + 1;
    }

    private int getLastItemIndex() {
        return nextLast == 0 ? items.length - 1 : nextLast - 1;
    }
}
