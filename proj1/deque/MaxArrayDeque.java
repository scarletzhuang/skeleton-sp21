package deque;

import java.util.Comparator;

public class MaxArrayDeque<T> extends ArrayDeque<T> {

    private Comparator<T> comparator;

    public MaxArrayDeque(Comparator<T> c) {
        super();
        this.comparator = c;
    }

    /**
     * Returns the max element in the deque.
     * If the deque is empty, returns null.
     */
    public T max() {
        return this.max(comparator);
    }

    public T max(Comparator<T> c) {
        if (this.isEmpty()) {
            return null;
        }

        T max = this.get(0);
        for (int i = 1; i < this.size(); i++) {
            if (c.compare(max, this.get(i)) < 0) {
                max = this.get(i);
            }
        }
        return max;
    }
}
