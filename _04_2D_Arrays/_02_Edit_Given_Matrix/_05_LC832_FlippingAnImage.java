package _02_Edit_Given_Matrix;

import java.util.Arrays;

/*
https://leetcode.com/problems/flipping-an-image/
 */
public class _05_LC832_FlippingAnImage {

    public static void flipAndInvertImage(int[][] A) {
        int n = A.length;
        for (int[] row : A)
            for (int i = 0; i * 2 < n; i++)
                //if first and last are same, toggle both
                //if first and last are opposite, doesn't matter if you toggle and swap, it remains same
                if (row[i] == row[n - i - 1])
                    row[i] = row[n - i - 1] ^= 1;
    }

    public static void main(String[] args) {
        int[][] arr = {{1, 1, 0}, {1, 0, 1}, {0, 0, 0}};
        flipAndInvertImage(arr);
        for (int[] a : arr) {
            System.out.println(Arrays.toString(a));
        }
    }
}
