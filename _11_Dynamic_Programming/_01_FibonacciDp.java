import java.util.Scanner;

public class _01_FibonacciDp {

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] qb = new int[n + 1];
        System.out.println(fibonacciMemoized(n, qb));
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
}
