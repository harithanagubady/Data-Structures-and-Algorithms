/*
https://leetcode.com/problems/matrix-diagonal-sum/
 */

public class _13_LC1572_MatrixDiagonalSum {

    public static int diagonalSum(int[][] mat) {
        int n = mat.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += mat[i][i];
            sum += mat[i][n - i - 1];
        }
        return n%2 == 0 ? sum : sum - mat[n/2][n/2];
    }

    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

        System.out.println(diagonalSum(arr));
    }
}
