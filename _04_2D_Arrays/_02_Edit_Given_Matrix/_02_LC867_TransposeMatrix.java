package _02_Edit_Given_Matrix;

import java.util.Arrays;

public class _02_LC867_TransposeMatrix {

    public static int[][] transpose(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] ans = new int[n][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ans[j][i] = matrix[i][j];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3}, {4, 5, 6}};
        int[][] ans = transpose(arr);
        for (int[] i : ans) {
            System.out.println(Arrays.toString(i));
        }
    }
}
