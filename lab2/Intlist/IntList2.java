public class IntList2 {
    public int first;
    public IntList2 rest;

    public IntList2(int f, IntList2 r){
        first = f;
        rest = r;
    }

    // Iterative
    // Reference: https://www.junhaow.com/studynotes/cs61b/cs61b%20p1.html
    public void addAdjacentIter(IntList2 p){
        /* if p == null, p.rest will no longer execute */
        if (p.rest == null) {
            /* size <= 1 */
            return;
        }

        /**
         * p.rest != null
         * p ends at the last node finally
         * loop through 1st ~ last 2nd node
         */
        while (p.rest != null) { /* p ends at the last node */
            if (p.first == p.rest.first) {
                /* merge */
                p.first *= 2;
                p.rest = p.rest.rest; /* it's okay if it is null */
            } else {
                p = p.rest;
            }
        }
    }

    // recursion
    // Reference: https://www.junhaow.com/studynotes/cs61b/cs61b%20p1.html
    public void addAdjacentRec(IntList2 p) {
        if (p == null) return;
        adj(p, p.rest);
    }

    // helper function - pass previous node recursively
    private void adj(IntList2 prev, IntList2 current) {
        if (current == null) return;
        if (prev.first == current.first) {
            prev.first *= 2;
            prev.rest = current.rest; // maybe null
            adj(prev, prev.rest); // I fixed this part that is wrong in the reference link.
        } else {
            adj(current, current.rest);
        }
    }

    // Display an IntList
    public void display(IntList2 L) {
        while (L.rest != null) {
            System.out.print(L.first);
            System.out.print(", ");
            L.first = L.rest.first;
            L.rest = L.rest.rest;
        }
        System.out.println(L.first);
    }

    public static void main(String[] args) {
        IntList2 L = new IntList2(3, null);
        L =new IntList2(2, L);
        L =new IntList2(1, L);
        L =new IntList2(1, L);

        // Method 1: Recursive
        L.addAdjacentRec(L);

        // Method 2: Iterative
//        L.addAdjacentIter(L);
        System.out.print("Final: ");
        L.display(L);
    }
}