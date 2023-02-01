package deque;

public interface Deque<T> {
    /** Adds an item of type T to the front of the deque.
     * Assume that item is never null.
     */
    void addFirst(T item);

    /** Adds an item of type T to the back of the deque.
     * Assume that item is never null.
     */
    void addLast(T item);

    /** Returns true if deque is empty, false otherwise. */
    default boolean isEmpty() {
        return size() == 0;
    };

    /** Returns the number of items in the deque. */
    int size();

    /** Prints the items in the deque from first to last. */
    void printDeque();

    /** Removes and returns the item at the front of the deque.
     * If no such item exists, returns null.
     */
    T removeFirst();

    /** Removes and returns the item at the back of the deque.
     * If no such item exists, returns null.
     */
    T removeLast();

    /** Gets the item at the given index.
     * If no such item exists returns null.
     */
    T get(int index);
}
