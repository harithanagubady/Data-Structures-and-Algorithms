package _01_MatrixTraversal;

import java.util.LinkedList;
import java.util.List;

/*
https://leetcode.com/problems/toeplitz-matrix/description/
 */
public class _05_LC766_ToeplitzMatrix {
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4},
                {5, 1, 2, 3},
                {9, 5, 1, 2}};
        System.out.println(isToeplitzMatrix(matrix));
    }

    public static boolean isToeplitzMatrix(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        if (n < 1) return false;
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] != matrix[i - 1][j - 1]) {
                    return false;
                }
            }
        }
        return true;
    }

    /*
    Followup1:
    What if the matrix is stored on disk, and the memory is limited such that
    you can only load at most one row of the matrix into the memory at once?
     */
    public boolean isToeplitzMatrix2(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) return true;
        int row = matrix.length;
        int col = matrix[0].length;
        List<Integer> buffer = new LinkedList<>();
        for (int j = 0; j < col; j++) buffer.add(matrix[0][j]);
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (buffer.get(j - 1) != matrix[i][j]) return false;
            }
            buffer.remove(buffer.size() - 1);
            buffer.add(0, matrix[i][0]); //remove last element and insert first element of new row. Because, this is how toeplitz matrix looks like in each row.
        }
        return true;
    }

    /*
    https://leetcode.com/problems/toeplitz-matrix/solutions/271388/java-solution-for-follow-up-1-2/
    Followup2:
    For the follow-up 2, we can only load a partial row at one time.
    We could split the whole matrix vertically into several sub-matrices,
    while each sub-matrix should have one column overlapped.
    We repeat the same method in follow-up 1 for each sub-matrix.

    For example:

    [1 2 3 4 5 6 7 8 9 0]              [1 2 3 4]              [4 5 6 7]              [7 8 9 0]
    [0 1 2 3 4 5 6 7 8 9]              [0 1 2 3]              [3 4 5 6]              [6 7 8 9]
    [1 0 1 2 3 4 5 6 7 8]     -->      [1 0 1 2]       +      [2 3 4 5]       +      [5 6 7 8]
    [2 1 0 1 2 3 4 5 6 7]              [2 1 0 1]              [1 2 3 4]              [4 5 6 7]
    [3 2 1 0 1 2 3 4 5 6]              [3 2 1 0]              [0 1 2 3]              [3 4 5 6]
     */
}