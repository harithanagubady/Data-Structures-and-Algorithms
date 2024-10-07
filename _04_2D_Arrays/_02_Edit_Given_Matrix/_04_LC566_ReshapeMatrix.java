package _02_Edit_Given_Matrix;

import java.util.Arrays;

public class _04_LC566_ReshapeMatrix {

    public static void main(String[] args) {
        int[][] arr = {{1, 2}, {3, 4}};
        int r = 1, c = 4;

        int[][] ans = matrixReshape1(arr, r, c);
        for (int[] a : ans) {
            System.out.println(Arrays.toString(a));
        }

        r = 2;
        c = 4;
        ans = matrixReshape1(arr, r, c);
        for (int[] a : ans) {
            System.out.println(Arrays.toString(a));
        }
    }

    private static int[][] matrixReshape1(int[][] arr, int r, int c) {

        int m = arr.length, n = arr[0].length;
        if (m*n != r*c) return arr;
        int[][] ans = new int[r][c];
        for (int i = 0; i < r * c; i++) {
            ans[i / c][i % c] = arr[i / n][i % n];
        }
        return ans;
    }

    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int m = mat.length;
        int n = mat[0].length;
        if (m * n != r * c) return mat;

        int[][] ans = new int[r][c];

        int x = 0, y = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ans[x][y] = mat[i][j];
                if (y < c - 1){
                    y += 1;
                    continue;
                }
                y = 0;
                x += 1;
            }
        }
        return ans;
    }
}
