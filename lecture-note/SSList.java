/** An SLList is a list of integers, which hides the terrible truth
 * of the nakedness within.
 */
public class SLList {

    private class IntNode {
        public int item;
        public intNode next;
    
        public IntNode(int i, IntNode n) {
            item = i;
            next = n;
        }
    }
    
    /* The first item (if it exists) is at sentinel.next */
    private IntNode sentinel;
    /* caches the size of the list */
    private int size;
    
    /* initialize an empty list */
    public SLList() {
        sentinel = new IntNode(42, null); // can put any number at the first place
        size = 0;
    }
    public SLList(int x) {
        sentinel = new IntNode(42, null)
        sentinel.next = new IntNode(x, null)
        size = 1;
    }

    /** Adds x to the front of the list. */
    public void addFirst(int x) {
        sentinel.next = new IntNode(x, sentinel.next);
        size += 1;
    }

    public int getFirst() {
        return sentinel.next.item;
    }

    public void addLast(int x) {
        size += 1;

        IntNode p = sentinel;

        while (p.next != null) {
            p = p.next;
        }
        p.next = new IntNode(x, null);
    }

    /** Returns the size of the list that starts at IntNode p. */
    /* private static int size(IntNode p) {
        if (p.next == null) {
            return 1;
        }
        
        return 1 + size(p.next);
    } */

    public int size() {
        return size;
    }

    public static void main(String[] args) {
        /* Creates a list of one integer, namely 10 */
        SLList L = new SLList(10);
        L.addFirst(10);
        L.addFirst(5);
        System.out.println(L.getFirst());
    }
}