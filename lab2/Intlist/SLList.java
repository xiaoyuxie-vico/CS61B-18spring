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

    public SLList(int x) {
        first = new IntNode(x, null);
    }

    /** Add the first item in the list */
    public void addFirst(int x) {
        first = new IntNode(x, first);
    }

    /** Returns the first item in the list */
    public int getFirst() {
        return first.item;
    }

//    public static void main(String[] args) {
//        /** Create a list of one integer, namely 10 */
//        SLList L = new SLList(10);
//        L.addFirst(10);
//        L.addFirst(5);
////        System.out.println(L.first.item);
////        System.out.println(L.getFirst());
//    }
}