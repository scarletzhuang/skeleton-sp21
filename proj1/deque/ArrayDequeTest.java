package deque;

import org.junit.Test;
import static org.junit.Assert.*;

/** Performs some basic array list tests. */
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
        ad.addFirst(0);
        ad.addFirst(-1);
        ad.addFirst(-2);
        ad.addLast(1);
        ad.addLast(2);
        ad.addLast(3);
        ad.addLast(4);
        ad.addLast(5);
        ad.addLast(6);
        ad.printDeque();
    }
}
