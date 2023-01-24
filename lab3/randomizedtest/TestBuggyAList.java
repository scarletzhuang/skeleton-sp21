package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.*;

/**
 * Created by hug.
 */
public class TestBuggyAList {
  // YOUR TESTS HERE
  @Test
  public void testThreeAddThreeRemove() {
      AListNoResizing<Integer> aList = new AListNoResizing();
      BuggyAList<Integer> buggyAList = new BuggyAList<>();
      aList.addLast(4);
      buggyAList.addLast(4);
      aList.addLast(5);
      buggyAList.addLast(5);
      aList.addLast(6);
      buggyAList.addLast(6);


      assertEquals(aList.removeLast(), buggyAList.removeLast());
      assertEquals(aList.removeLast(), buggyAList.removeLast());
      assertEquals(aList.removeLast(), buggyAList.removeLast());
  }

    @Test
    public void randomizedTest() {
        AListNoResizing<Integer> L = new AListNoResizing<>();
        BuggyAList<Integer> buggyL = new BuggyAList<>();

        int N = 5000;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 4);
            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                L.addLast(randVal);
                buggyL.addLast(randVal);
            } else if (operationNumber == 1) {
                // size
                int size = L.size();
                assertEquals(size, buggyL.size());
            } else if (operationNumber == 2) {
                // getLast
                if (L.size() == 0) continue;
                int lastVal = L.getLast();
                assertEquals(Optional.of(lastVal), Optional.of(buggyL.getLast()));
            } else if (operationNumber == 3) {
                // removeLast
                if (L.size() == 0) continue;
                int removedVal = L.removeLast();
                assertEquals(Optional.of(removedVal), Optional.of(buggyL.removeLast()));
            }
        }
    }
}
