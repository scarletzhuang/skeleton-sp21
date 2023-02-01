package deque;

import org.junit.Test;

import java.util.Comparator;

import static org.junit.Assert.*;

public class MaxArrayDequeTest {

    @Test
    public void getMaxTest() {
        Comparator<String> lengthComparator = new StringLengthComparator();
        MaxArrayDeque<String> mad = new MaxArrayDeque<>(lengthComparator);

        mad.addFirst("ibc");
        mad.addLast("abcdefff");
        mad.addLast("bn");

        assertEquals("abcdefff", mad.max());

        Comparator<String> alphabeticComparator = new StringAlphabeticComparator();
        assertEquals("ibc", mad.max(alphabeticComparator));
    }

    private static class StringLengthComparator implements Comparator<String> {

        @Override
        public int compare(String o1, String o2) {
            return o1.length() - o2.length();
        }
    }

    private static class StringAlphabeticComparator implements Comparator<String> {


        @Override
        public int compare(String o1, String o2) {
            return o1.charAt(0) - o2.charAt(0);
        }
    }

}
