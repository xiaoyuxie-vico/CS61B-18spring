/** count Fibonacci number */
public class CreateFibonacci {
    public static int fib(int n) {
        if ((n == 1) || (n == 2)) {
            return 1;
        } else {
            return fib(n-1) + fib(n-2);
        }
    }

    public static void main(String[] args) {
        int fib_num;
        fib_num = fib(8);
        System.out.println(fib_num);
    }
}

