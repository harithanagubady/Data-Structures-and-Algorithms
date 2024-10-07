package _02_Edit_Given_Matrix;

import java.util.Arrays;

public class _06_LC2022_1Dto2DArray {

    public static void main(String[] args) {
        int[] matrix = {1, 2, 3, 4};
        int[][] result = construct2DArray(matrix, 2, 2);
        for (int[] res : result) {
            System.out.println(Arrays.toString(res));
        }
    }
    public static int[][] construct2DArray(int[] original, int m, int n) {
        int len = original.length;

        if (m*n != len) return new int[0][0];

        int[][] result = new int[m][n];
        for (int i = 0; i < len; i++) {
            result[i/n][i%n] = original[i];
        }
        return result;
    }
}
