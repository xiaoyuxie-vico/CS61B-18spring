/** count Fibonacci number */
public class CreateFibonacci {
    public static int fib(int n) {
        if (n <= 1) {
            return n;
        } else {
            return fib(n - 1) + fib(n - 2);
        }
    }

    public static int fib2(int n, int k, int f0, int f1) {
        if (n == k) {
            return f0;
        } else {
            return fib2(n, k + 1, f1, f0 + f1);
        }
    }

    public static void main(String[] args) {
        int fib_num1, fib_num2;

        // method 1
        fib_num1 = fib(8);
        System.out.println(fib_num1);

        // method 2
        fib_num2 = fib2(8, 2, 0, 1);
        System.out.println(fib_num2);
    }
}

