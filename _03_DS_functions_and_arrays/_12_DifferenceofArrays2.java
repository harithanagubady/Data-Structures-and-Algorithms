import java.util.Scanner;

/*
Two numbers represented as arrays are given as a1 and a2
Find a1 - a2 and print the array
eg: a1 = [2, 3], a2 = [3, 2], diff = [9], print -9
a1 = [3, 2], a2 = [2, 3], diff = [9], print 9
 */
public class _12_DifferenceofArrays2 {
    public static void main(String[] args) throws Exception {

        Scanner scn = new Scanner(System.in);
        int n1 = scn.nextInt();
        int[] a1 = new int[n1];

        for (int i = 0; i < a1.length; i++) {
            a1[i] = scn.nextInt();
        }

        int n2 = scn.nextInt();
        int[] a2 = new int[n2];

        for (int i = 0; i < a2.length; i++) {
            a2[i] = scn.nextInt();
        }

        int[] diff = new int[Math.max(n1, n2)];
        int c = 0;
        int i = n1 - 1;
        int j = n2 - 1;
        int k = diff.length - 1;

        c = getDiff(a1, a2, diff, c, i, j, k);

        int idx = 0;

        if (c == -1) {
            diff = new int[Math.max(n1, n2)];
            System.out.println("tttttttt");
            getDiff(a2, a1, diff, 0, n2 - 1, n1 - 1, k);
            System.out.print("-");
        }

        while (idx < diff.length && diff[idx] == 0) {
            idx++;
        }

        if (idx == diff.length) {
            System.out.println("0");
        }
        while (idx < diff.length) {
            System.out.print(diff[idx++]);
        }
    }

    private static int getDiff(int[] a1, int[] a2, int[] diff, int c, int i, int j, int k) {
        while (k >= 0) {
            int a1v = (i >= 0 ? a1[i--] : 0);
            int a2v = (j >= 0 ? a2[j--] : 0);
            int d = a1v - a2v + c;

            if (d >= 0) {
                c = 0;
            } else {
                d = d + 10;
                c = -1;
            }
            diff[k] = d;
            k--;
        }
        return c;
    }
}