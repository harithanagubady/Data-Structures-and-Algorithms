
/*
https://leetcode.com/problems/longest-valid-parentheses/description/
 */
public class _48_RotateImage {


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
                matrix[i][j] = matrix[span - j][i];
                matrix[span - j][i] = matrix[span - i][span - j];
                matrix[span - i][span - j] = matrix[j][span - i];
                matrix[j][span - i] = temp;
            }
            boundary--;
        }
    }

    public static void main(String[] args) {
        _48_RotateImage ri = new _48_RotateImage();
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
