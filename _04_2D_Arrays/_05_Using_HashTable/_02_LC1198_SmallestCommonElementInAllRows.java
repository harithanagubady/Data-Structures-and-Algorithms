package _05_Using_HashTable;

import java.util.Arrays;

/*
https://leetcode.com/problems/find-smallest-common-element-in-all-rows/

Given an m x n matrix mat where every row is sorted in strictly increasing order, return the smallest common element in all rows.

If there is no common element, return -1.


Example 1:

Input: mat = [[1,2,3,4,5],[2,4,5,8,10],[3,5,7,9,11],[1,3,5,7,9]]
Output: 5

Example 2:

Input: mat = [[1,2,3],[2,3,4],[2,3,5]]
Output: 2

 */
public class _02_LC1198_SmallestCommonElementInAllRows {

    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3, 5}, {2, 3, 5, 7}, {1, 5, 6, 10}};
        //System.out.println(approach1(arr));

        int[][] arr2 = {{1, 2, 2, 5}, {2, 3, 5, 7}, {1, 5, 6, 10}};
        //System.out.println(approach2bSearch(arr2));

        for (int[] a : arr2) {
            System.out.println(Arrays.toString(a));
        }
        System.out.println(approach3multipointer(arr2));
    }

    //O(mn)
    //when duplicates doesn't exist in each row
    public static int approach1(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[] count = new int[10001];
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < m; i++) {
                if (++count[mat[i][j]] == m) return mat[i][j];
            }
        }
        return -1;
    }

    //for every element in first row, binary search on each other row
    //works even when duplicates exist
    //O(mnlogn)
    public static int approach2bSearch(int[][] mat) {
        if (mat.length == 1)
            return mat[0][0];

        for (int target : mat[0]) {
            boolean common = true;
            for (int r = 1; r < mat.length; r++) {
                int[] row = mat[r];
                boolean b = bSearch(row, target);
                if (!b) {
                    common = false;
                    break;
                }
            }
            if (common)
                return target;
        }

        return -1;
    }

    //Efficient approach for duplicates exists
    //O(mn)
    public static int approach3multipointer(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[] p = new int[m]; // record col index of each row
        int max = mat[0][0];
        for (int[] arr : mat) {
            max = Math.max(max, arr[0]);
        }
        while (true) {
            int nextMax = 0;
            boolean flag = true;
            for (int i = 0; i < m; i++) {
                while (p[i] < n && mat[i][p[i]] < max) {
                    p[i]++;
                    flag = false;
                }
                if (p[i] == n) return -1;
                nextMax = Math.max(nextMax, mat[i][p[i]]);
            }
            max = nextMax;

            if (flag) break;
        }
        return max;
    }

    private static boolean bSearch(int[] arr, int target) {
        int m = arr.length;

        int left = 0;
        int right = m - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int midVal = arr[mid];
            if (midVal == target)
                return true;

            if (midVal < target)
                left = mid + 1;
            else
                right = mid - 1;
        }

        return false;
    }

}
