import edu.princeton.cs.algs4.In;

import java.util.Arrays;

/*
Using sentinel
 */

public class SLList2 {
    private static class IntNode {
        public int item;
        public IntNode next;

        public IntNode(int i, IntNode n) {
            item = i;
            next = n;
        }
    }

    private IntNode sentinel;
    private int size;

    public SLList2() {
        // initialize with no inputs
        sentinel = new IntNode(63, null);
        size = 1;
    }

    public SLList2(int x) {
        // initialize with a integer
        sentinel = new IntNode(63, null);
        sentinel.next = new IntNode(x, null);
        size = 1;
    }

    public SLList2(int[] x) {
        // initialize with an array
        size = 0;
        sentinel = new IntNode(63, null);
        for (int i = 0; i < x.length; i++) {
            // get the item from array inversely
            sentinel.next = new IntNode(x[x.length-i-1], null);
            size += 1;
        }
    }

    /** Add the first item in the list */
    public void addFirst(int x) {
        sentinel.next = new IntNode(x, sentinel.next);
        size += 1;
    }

    /** Returns the first item in the list */
    public int getFirst() {
        return sentinel.next.item;
    }

    /**
     * Returns the last item in the list
     * @return the last item
     */
    public int getLast() {
        if (sentinel.next == null) {
            return sentinel.item;
        }
        sentinel = sentinel.next;
        return getLast();
    }

    /**
     * Add an item to a list
     * @param args int x
     */
    public void addLast(int x) {
        size += 1;
        IntNode p = sentinel;

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

    public int deleteFirst() {
        /* sentinel.next or sentinel.next.next
        could be null when size == 0 */
        if (sentinel.next == null) {
            return -1;
        }

        IntNode deleteNode = sentinel.next;

        if (sentinel.next.next == null) {
            sentinel.next = new IntNode(-1, null);
            return deleteNode.item;
        }
        sentinel.next = sentinel.next.next;
        return deleteNode.item;
    }
    /*
    We want to add a method to IntList so that if 2 numbers
    in a row are the same, we add them together and
    make one large node.
     */
    public void addAdjacent() {
        int first = getFirst();
        int second = sentinel.next.next.item;
        System.out.println(first);
        System.out.println(second);

//        if (sentinel.next.item == sentinel.next.next.item) {
//
//            sentinel.next.item += sentinel.next.next.item;
//            sentinel.next.next =
//
//        }
    }

    public static void main(String[] args) {
        /** Test the constructor that takes in an array of integers*/
        int[] arr = new int[]{1, 1, 2, 3};
        SLList2 L = new SLList2(arr);
//        System.out.println(L.getFirst());
        L.addAdjacent();
    }
}