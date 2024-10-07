package _01_MatrixTraversal;

/*
https://leetcode.com/problems/spiral-matrix-ii/description/
 */
import java.util.Arrays;

public class _02_LC59_SpiralMatrix2 {

    public static void main(String[] args) {
        int[][] ans = generateMatrix(3);
        for (int[] i : ans) {
            System.out.println(Arrays.toString(i));
        }
    }
    public static int[][] generateMatrix(int n) {
        int[][] arr = new int[n][n];

        int rowStart = 0, rowEnd = n - 1;
        int colStart = 0, colEnd = n - 1;

        int count = 1;
        while (count <= n * n) {

            //topWall
            for (int j = colStart; j <= colEnd; j++) {
                arr[rowStart][j] = count;
                count++;
            }
            rowStart++;

            //rightWall
            for (int i = rowStart; i <= rowEnd; i++) {
                arr[i][colEnd] = count;
                count++;
            }
            colEnd--;

            //bottomWall
            for (int j = colEnd; j >= colStart; j--) {
                arr[rowEnd][j] = count;
                count++;
            }
            rowEnd--;

            //leftWall
            for (int i = rowEnd; i >= rowStart; i--) {
                arr[i][colStart] = count;
                count++;
            }
            colStart++;
        }
        return arr;
    }
}
