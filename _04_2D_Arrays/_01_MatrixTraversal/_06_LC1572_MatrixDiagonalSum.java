package _01_MatrixTraversal;/*
https://leetcode.com/problems/matrix-diagonal-sum/description/
 */

public class _06_LC1572_MatrixDiagonalSum {

    public static int diagonalSum(int[][] mat) {
        int n = mat.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            if (i != n - i - 1)
                sum += mat[i][n - i - 1];
            sum += mat[i][i];
        }
        return sum;
    }

    public static int diagonalSum2(int[][] mat) {
        int n = mat.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += mat[i][i];
            sum += mat[i][n - i - 1];
        }
        return n%2 == 0 ? sum : sum - mat[n/2][n/2];
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};
        System.out.println(diagonalSum(matrix));
        System.out.println(diagonalSum2(matrix));
    }
}
