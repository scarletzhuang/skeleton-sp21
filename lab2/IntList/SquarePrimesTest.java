package IntList;

import static org.junit.Assert.*;
import org.junit.Test;

public class SquarePrimesTest {

    /**
     * Here is a test for isPrime method. Try running it.
     * It passes, but the starter code implementation of isPrime
     * is broken. Write your own JUnit Test to try to uncover the bug!
     */
    @Test
    public void testSquarePrimesSimple() {
        IntList lst = IntList.of(14, 15, 16, 17, 18);
        boolean changed = IntListExercises.squarePrimes(lst);
        assertEquals("14 -> 15 -> 16 -> 289 -> 18", lst.toString());
        assertTrue(changed);
    }

    @Test
    public void testSquarePrimeTrue() {
        IntList lst = IntList.of(1, 2, 4, 7, 13);
        boolean changed = IntListExercises.squarePrimes(lst);
        assertEquals("1 -> 4 -> 4 -> 49 -> 169", lst.toString());
        assertTrue(changed);
    }

    @Test
    public void testSquarePrimeFalse() {
        IntList lst = IntList.of(6, 9, 22);
        boolean changed = IntListExercises.squarePrimes(lst);
        assertEquals("6 -> 9 -> 22", lst.toString());
        assertFalse(changed);
    }
}
