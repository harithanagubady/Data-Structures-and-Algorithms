package _04_Given_Two_Matrices;/*
https://leetcode.com/problems/sparse-matrix-multiplication/description/
 */

import java.util.*;

public class _01_LC311_SparseMatrixMultiplication {

    public static void main(String[] args) {
        int[][] A = {{1, 0, 0},
                {-1, 0, 3}};

        int[][] B = {{7, 0, 0},
                {0, 0, 0},
                {0, 0, 1}};

        int[][] ans = sparseMultiplication(A, B);
        for (int[] i : ans) {
            System.out.println(Arrays.toString(i));
        }
    }

    public static int[][] sparseMultiplication(int[][] mat1, int[][] mat2) {

        Map<Integer, Integer>[] rowMap = rowCompression(mat1);
        Map<Integer, Integer>[] colMap = colCompression(mat2);
        return multiply(rowMap, colMap);
    }

    private static int[][] multiply (Map<Integer, Integer>[] rowMap, Map<Integer, Integer>[] colMap) {

        int m = rowMap.length;
        int n = colMap.length;
        int[][] res = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (Map.Entry<Integer, Integer> p : rowMap[i].entrySet()) {
                    if (colMap[j].containsKey(p.getKey())) {
                        res[i][j] += (colMap[j].get(p.getKey()) * p.getValue());
                    }
                }
            }
        }
        return res;
    }

    private static Map<Integer, Integer>[] rowCompression(int[][] mat) {
        int m = mat.length;
        Map<Integer, Integer>[] l = new HashMap[m];
        for (int i = 0; i < m; i++) {
            l[i] = new HashMap<>();
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] != 0) {
                    l[i].put(j, mat[i][j]);
                }
            }
        }
        return l;
    }

    private static Map<Integer, Integer>[] colCompression(int[][] mat) {
        int n = mat[0].length;
        Map<Integer, Integer>[] l = new HashMap[n];
        for (int j = 0; j < n; j++) {
            l[j] = new HashMap<>();
            for (int i = 0; i < mat.length; i++) {
                if (mat[i][j] != 0) {
                    l[j].put(i, mat[i][j]);
                }
            }
        }
        return l;
    }

}
