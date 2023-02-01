package deque;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Performs some basic array list tests.
 */
public class ArrayDequeTest {

    @Test
    public void addIsEmptySizeTest() {
        ArrayDeque<String> arrayDeque = new ArrayDeque<>();
        assertTrue("A newly initialized ArrayDeque should be empty", arrayDeque.isEmpty());

        arrayDeque.addFirst("front");
        assertEquals(1, arrayDeque.size());
        assertFalse(arrayDeque.isEmpty());

        arrayDeque.addLast("middle");
        assertEquals(2, arrayDeque.size());

        arrayDeque.addLast("back");
        assertEquals(3, arrayDeque.size());

        System.out.println("Printing out deque: ");
        arrayDeque.printDeque();
    }

    @Test
    public void resizeTest() {
        ArrayDeque<Integer> ad1 = new ArrayDeque<>();
        ArrayDeque<Integer> ad2 = new ArrayDeque<>();
        for (int i = 0; i < 100; i++) {
            ad1.addLast(i);
            ad2.addFirst(i);
        }

        assertEquals(100, ad1.size());
        assertEquals(100, ad2.size());
    }

    @Test
    public void removeTest() {
        ArrayDeque<Integer> ad1 = new ArrayDeque<>();
        ArrayDeque<Integer> ad2 = new ArrayDeque<>();
        for (int i = 0; i < 100; i++) {
            ad1.addLast(i);
            ad2.addFirst(i);
        }

        for (int i = 0; i < 50; i++) {
            ad1.removeFirst();
            ad2.removeLast();
        }

        assertEquals(50, ad1.size());
        assertEquals(50, ad2.size());
    }

    @Test
    public void getTest() {
        ArrayDeque<Integer> ad = new ArrayDeque<>();

        for (int i = 0; i < 3; i++) {
            ad.addFirst(-i);
        }

        for (int i = 1; i < 7; i++) {
            ad.addLast(i);
        }

        for (int i = 0; i < 9; i++) {
            assertEquals(i - 2, (int) ad.get(i));
        }
    }

    @Test
    public void randomTest() {
        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();

        int N = 5000;
        for (int i = 0; i < N; i++) {
            int opNumber = StdRandom.uniform(0, 5);
            if (opNumber == 0) {
                int ranValue = StdRandom.uniform(0, 100);
                arrayDeque.addLast(ranValue);
            } else if (opNumber == 1) {
                int ranValue = StdRandom.uniform(0, 100);
                arrayDeque.addFirst(ranValue);
            } else if (opNumber == 2) {
                arrayDeque.removeFirst();
            } else if (opNumber == 3) {
                arrayDeque.removeLast();
            } else if (opNumber == 4) {
                if (arrayDeque.size() == 0) continue;
                int ranValue = StdRandom.uniform(0, arrayDeque.size());
                arrayDeque.get(ranValue);
            }
        }
    }
}
