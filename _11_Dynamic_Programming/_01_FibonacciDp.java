import java.util.Scanner;

public class _01_FibonacciDp {

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] qb = new int[n + 1];
        //System.out.println(fibonacciMemoized(n, qb));
        System.out.println(fibonacciTabulation(n));
    }

    public static int fibonacciMemoized(int n, int[] qb) {

        if (n == 0 || n == 1) {
            return n;
        }
        if (qb[n] != 0) {
            return qb[n];
        }
        System.out.println("Calling fibonacci (" + n + ")");
        int fibm1 = fibonacciMemoized(n - 1, qb);
        int fibm2 = fibonacciMemoized(n - 2, qb);
        int fibm = fibm1 + fibm2;
        qb[n] = fibm;

        return fibm;
    }

    public static int fibonacciTabulation(int n) {

        int[] fib = new int[n + 1];
        fib[0] = 0;
        if (n > 0) fib[1] = 1;
        for (int i = 2; i <= n; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }

        return fib[n];
    }
}
