/*
https://leetcode.com/problems/row-with-maximum-ones/description/
 */

import java.util.Arrays;

public class _14_LC2643_RowWithMaxOnes {

    public static void main(String[] args) {
        int[][] mat = {{0, 1}, {1, 0}};
        System.out.println(Arrays.toString(rowAndMaximumOnes(mat)));
    }
    public static int[] rowAndMaximumOnes(int[][] mat) {
        int maxRow = -1, maxCount = -1;
        for (int i = 0; i < mat.length; i++) {
            int count = 0;
            for (int j : mat[i]) {
                count += j;
            }
            if (maxCount < count) {
                maxCount = count;
                maxRow = i;
            }
        }
        return new int[] {maxRow, maxCount};
    }
}
