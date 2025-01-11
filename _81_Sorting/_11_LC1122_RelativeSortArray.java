/*
https://leetcode.com/problems/relative-sort-array/description/
 */

import java.util.Arrays;

public class _11_LC1122_RelativeSortArray {

    //Counting Sort - O(n)
    public static int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] count = new int[1001];
        for (int i : arr1) count[i]++;
        int idx = 0;
        for (int n : arr2) {
            while (count[n]-- > 0) {
                arr1[idx++] = n;
            }
        }
        for (int i = 0; i < count.length; i++) {
            while (count[i]-- > 0) {
                arr1[idx++] = i;
            }
        }
        return arr1;
    }

    public static void main(String[] args) {
        int[] arr1 = {2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19};
        int[] arr2 = {2, 1, 4, 3, 9, 6};
        System.out.println(Arrays.toString(relativeSortArray(arr1, arr2)));
    }
}
