package _02_Edit_Given_Matrix;

import java.util.Arrays;

/*
https://leetcode.com/problems/set-matrix-zeroes/description/
 */
public class _03_LC73_SetMatrixZeroes {

    public static void main(String[] args) {
        int[][] arr = {{0, 1, 2, 0},
                {3, 4, 5, 2},
                {1, 3, 1, 5}};

        //bruteForceSolution(arr);
        //solutionWith1DArray(arr);
        optimalSolutionWithout1DArray(arr);
        for (int[] i : arr) {
            System.out.println(Arrays.toString(i));
        }
    }

    //O(mn*(m+n)    O(mn)
    private static void bruteForceSolution(int[][] arr) {
        int m = arr.length, n = arr[0].length;
        int[][] temp = new int[m][n];
        for (int i = 0; i < m; i++) {
            System.arraycopy(arr[i], 0, temp[i], 0, n);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 0)
                    setRowAndColZeroes(temp, i, j);
            }
        }
        for (int i = 0; i < m; i++) {
            System.arraycopy(temp[i], 0, arr[i], 0, n);
        }
    }

    //O(mn)     O(m + n)
    private static void solutionWith1DArray(int[][] arr) {
        int m = arr.length, n = arr[0].length;

        int[] rowArray = new int[n];
        int[] colArray = new int[m];
        Arrays.fill(rowArray, 1);
        Arrays.fill(colArray, 1);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 0) {
                    rowArray[j] = 0;
                    colArray[i] = 0;
                }
            }
        }
        setRowAndColZeroes1(arr, rowArray, colArray);
    }

    //O(mn)     O(1)
    private static void optimalSolutionWithout1DArray(int[][] arr) {
        int m = arr.length, n = arr[0].length;
        int[][] temp = new int[m][n];
        for (int i = 0; i < m; i++) {
            System.arraycopy(arr[i], 0, temp[i], 0, n);
        }
        boolean hasZeroInRow1 = false;
        boolean hasZeroInCol1 = false;

        for (int i = 0; i < m; i++) {
            if (arr[i][0] == 0) {
                hasZeroInCol1 = true;
                break;
            }
        }
        for (int j = 0; j < n; j++) {
            if (arr[0][j] == 0) {
                hasZeroInRow1 = true;
                break;
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (arr[i][j] == 0) {
                    arr[0][j] = 0;
                    arr[i][0] = 0;
                }
            }
        }
        setRowAndColZeroes2(arr, hasZeroInRow1, hasZeroInCol1);
    }

    private static void setRowAndColZeroes2(int[][] arr, boolean hasZeroInRow1, boolean hasZeroInCol1) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j < arr[0].length; j++) {
                if (arr[i][0] == 0 || arr[0][j] == 0) {
                    arr[i][j] = 0;
                }
            }
        }
        if (hasZeroInRow1) {
            Arrays.fill(arr[0], 0);
        }
        if (hasZeroInCol1) {
            for (int i = 0; i < arr.length; i++) {
                arr[i][0] = 0;
            }
        }
    }

    private static void setRowAndColZeroes(int[][] temp, int row, int col) {

        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < temp[0].length; j++) {
                if (i == row || j == col) {
                    temp[i][j] = 0;
                }
            }
        }
    }

    private static void setRowAndColZeroes1(int[][] temp, int[] rowsArray, int[] colArray) {

        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < temp[0].length; j++) {
                if (rowsArray[j] == 0 || colArray[i] == 0) {
                    temp[i][j] = 0;
                }
            }
        }
    }
}
