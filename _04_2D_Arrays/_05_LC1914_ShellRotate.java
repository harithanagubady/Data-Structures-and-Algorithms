/*
https://leetcode.com/problems/cyclically-rotating-a-grid/description/
 */

import java.util.*;

public class _05_LC1914_ShellRotate {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();

        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = scn.nextInt();
            }
        }

        int r = scn.nextInt();

        for (int s = 0; s < Math.min(n,m)/2; s++) {
            rotateShell(arr, s, r);
        }
        display(arr);
    }

    public static void rotateShell(int[][] arr, int s, int r) {
        int[] oned = fillOnedFromShell(arr, s);
        rotate(oned, r);
        fillShellFromOned(arr, s, oned);
    }

    public static void rotate(int[] oned, int r) {
        r = r % oned.length;
        if (r < 0) {
            r += oned.length;
        }

        reverse(oned, 0, oned.length - r - 1);
        reverse(oned, oned.length - r, oned.length - 1);
        reverse(oned, 0, oned.length - 1);
    }

    public static void reverse(int[] arr, int i, int j) {
        while (i < j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }

    public static int[] fillOnedFromShell(int[][] arr, int s) {
        int minr = s;
        int minc = s;
        int maxr = arr.length - s - 1;
        int maxc = arr[0].length - s - 1;
        int size = 2 * (maxr - minr) + 2 * (maxc - minc);
        int[] oned = new int[size];

        int index = 0;
        for (int i = minr, j = minc; i <= maxr; i++) {
            oned[index] = arr[i][j];
            index++;
        }

        for (int i = maxr, j = minc + 1; j <= maxc; j++) {
            oned[index] = arr[i][j];
            index++;
        }

        for (int i = maxr - 1, j = maxc; i >= minr; i--) {
            oned[index] = arr[i][j];
            index++;
        }

        for (int i = minr, j = maxc - 1; j > minc; j--) {
            oned[index] = arr[i][j];
            index++;
        }

        return oned;
    }

    public static void fillShellFromOned(int[][] arr, int s, int[] oned) {
        int minr = s;
        int minc = s;
        int maxr = arr.length - s - 1;
        int maxc = arr[0].length - s - 1;

        int index = 0;
        for (int i = minr, j = minc; i <= maxr; i++) {
            arr[i][j] = oned[index];
            index++;
        }

        for (int i = maxr, j = minc + 1; j <= maxc; j++) {
            arr[i][j] = oned[index];
            index++;
        }

        for (int i = maxr - 1, j = maxc; i >= minr; i--) {
            arr[i][j] = oned[index];
            index++;
        }

        for (int i = minr, j = maxc - 1; j > minc; j--) {
            arr[i][j] = oned[index];
            index++;
        }
    }

    public static void display(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

}