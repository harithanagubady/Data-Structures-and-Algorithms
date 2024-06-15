import java.util.Scanner;


/*
https://leetcode.com/problems/climbing-stairs/description/
 */
public class _02_ClimbStairs {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        System.out.println(countPaths(n, new int[n + 1]));
    }

    public static int countPaths(int n, int[] qb) {

        if (n == 0) {
            return 1;
        }

        if (n < 0) {
            return 0;
        }

        if (qb[n] != 0) {
            return qb[n];
        }
        System.out.println("countPaths(" + n + ")");
        int c1 = countPaths(n - 1, qb);
        int c2 = countPaths(n - 2, qb);
        int c3 = countPaths(n - 3, qb);

        int c = c1 + c2 + c3;
        qb[n] = c;
        return c;
    }
}
