import edu.princeton.cs.introcs.In;

public class SLList {
    private static class IntNode {
        public int item;
        public IntNode next;

        public IntNode(int i, IntNode n) {
            item = i;
            next = n;
        }
    }

    private IntNode first;
    private int size;

    public SLList(int x) {
        first = new IntNode(x, null);
        size = 1;
    }

    /** Add the first item in the list */
    public void addFirst(int x) {
        first = new IntNode(x, first);
        size += 1;
    }

    /** Returns the first item in the list */
    public int getFirst() {
        return first.item;
    }

    /**
     * Returns the last item in the list
     * @return the last item
     */
    public int getLast() {
        if (first.next == null) {
            return first.item;
        }
        first = first.next;
        return getLast();
    }

    /**
     * Add an item to a list
     * @param args int x
     */
    public void addLast(int x) {
        size += 1;

        IntNode p = first;

        /* Advance p to the end of the list. */
        while (p.next != null) {
            p = p.next;
        }
        p.next = new IntNode(x, null);
    }

//    /** Returns the size of the list starting at IntNode p. */
//    private static int size(IntNode p) {
//        if (p.next == null) {
//            return 1;
//        }
//
//        return 1 + size(p.next);
//    }
//
//    public int size() {
//        return size(first);
//    }

    public int size() {
        return size;
    }

//    public static int deleteFirst() {
//
//    }

    public static void main(String[] args) {
        /** Create a list of one integer, namely 10 */
        SLList L = new SLList(10);
        L.addFirst(10);
        System.out.println(L.getFirst());
        L.addFirst(5);
//        L.deleteFirst();
        System.out.println(L.getFirst());
//        L.addLast(100);
//        System.out.println(L.getLast());
//        System.out.println(L.size());
    }
}