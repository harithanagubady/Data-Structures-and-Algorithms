package _02_Edit_Given_Matrix;/*
https://leetcode.com/problems/rotate-image/description/
 */

public class _01_LC48_RotateBy90deg {

    public void rotateApproach1(int[][] matrix) {
        for (int col = 0; col < matrix[0].length; col++) {
            int row1 = 0;
            int row2 = matrix.length - 1;
            while (row1 < row2) {
                int tmp = matrix[row1][col];
                matrix[row1++][col] = matrix[row2][col];
                matrix[row2--][col] = tmp;
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i + 1; j < matrix[i].length; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
    }

    public void rotateApproach2(int[][] matrix) {
        int n = matrix.length;
        int span = n - 1;
        int boundary = span;
        for (int i = 0; i < boundary; i++) {
            for (int j = i; j < boundary; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[span - j][i]; //element from same col as row and row index is same as col index except from bottom
                matrix[span - j][i] = matrix[span - i][span - j]; //row index same as col index, elements from first col replaced by last row
                matrix[span - i][span - j] = matrix[j][span - i]; // col is same as row except in reverse order
                matrix[j][span - i] = temp;
            }
            boundary--;
        }
    }

    /*
    row : 0 to n/2
    col: row to n - row - 1

    Say, we are at row : 0, col : 0 to n - 1
    We perform 3 swaps
    top-left cell <-> top-right cell
    top-left cell <-> bottom-right cell
    top-left cell <-> bottom-left cell

    eg:
    original matrix: 3 x 3, row: 0, col: 0 to 2
    1 2 3       3 2 1       9 2 1       7 2 1
    4 5 6   ->  4 5 6   ->  4 5 6   ->  4 5 6
    7 8 9       7 8 9       7 8 3       9 8 3

    The current group of cells has been rotated by 90 degrees
    Now continue for next group row : 1, col : 1 to n - 2

     */
    public void rotateApproach3(int[][] matrix) {
        int n = matrix.length;
        int span = n - 1;
        int boundary = span;
        for (int i = 0; i < boundary; i++) {
            for (int j = i; j < boundary; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[span - j][i]; //element from same col as row and row index is same as col index except from bottom
                matrix[span - j][i] = matrix[span - i][span - j]; //row index same as col index, elements from first col replaced by last row
                matrix[span - i][span - j] = matrix[j][span - i]; // col is same as row except in reverse order
                matrix[j][span - i] = temp;
            }
            boundary--;
        }
    }

    public static void main(String[] args) {
        _01_LC48_RotateBy90deg ri = new _01_LC48_RotateBy90deg();
        int[][] matrix = {{1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};
        ri.rotateApproach1(matrix);
        printMatrix(matrix);
        System.out.println();

        int[][] matrix1 = {{1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};
        ri.rotateApproach2(matrix1);
        printMatrix(matrix1);
    }

    private static void printMatrix(int[][] matrix) {

        for (int[] ia : matrix) {
            for (int i : ia) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

}
