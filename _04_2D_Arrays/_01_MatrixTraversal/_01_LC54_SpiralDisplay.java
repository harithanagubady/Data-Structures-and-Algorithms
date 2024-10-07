package _01_MatrixTraversal;/*
https://leetcode.com/problems/spiral-matrix/description/
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class _01_LC54_SpiralDisplay {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = scn.nextInt();
            }
        }
        spiralOrderAntiClockWise(n, m, arr);
        System.out.println("========================");
        List<Integer> l = spiralOrderClockWise(n, m, arr);
        for (int i : l) {
            System.out.println(i);
        }
    }

    private static void spiralOrderAntiClockWise(int n, int m, int[][] arr) {
        int max = n * m;
        int count = 0;
        int min_row = 0;
        int min_col = 0;
        int max_row = n -1;
        int max_col = m -1;
        while (count < max) {

            //left wall
            for (int i = min_row; i <= max_row; i++) {
                System.out.println(arr[i][min_col]);
                count++;
            }
            min_col++;

            //bottom wall
            for(int i = min_col; i <= max_col; i++){
                System.out.println(arr[max_row][i]);
                count++;
            }
            max_row--;

            //right wall
            for(int i = max_row; i >= min_row; i--) {
                System.out.println(arr[i][max_col]);
                count++;
            }
            max_col--;

            //top wall
            for(int i = max_col; i >= min_col; i--) {
                System.out.println(arr[min_row][i]);
                count++;
            }
            min_row++;
        }
    }

    public static List<Integer> spiralOrderClockWise(int n, int m, int[][] matrix) {

        int size = n * m;
        int minRow = 0, maxRow = n - 1, minCol = 0, maxCol = m - 1;
        List<Integer> l = new ArrayList<>();
        while (l.size() < size) {

            //topWall
            for (int i = minCol; i <= maxCol && l.size() < size; i++) {
                l.add(matrix[minRow][i]);
            }
            minRow++;

            //rightWall
            for (int i = minRow; i <= maxRow && l.size() < size; i++) {
                l.add(matrix[i][maxCol]);
            }
            maxCol--;

            //bottomWall
            for (int i = maxCol; i >= minCol && l.size() < size; i--) {
                l.add(matrix[maxRow][i]);
            }
            maxRow--;

            //leftWall
            for (int i = maxRow; i >= minRow && l.size() < size; i--) {
                l.add(matrix[i][minCol]);
            }
            minCol++;
        }

        return l;
    }
}