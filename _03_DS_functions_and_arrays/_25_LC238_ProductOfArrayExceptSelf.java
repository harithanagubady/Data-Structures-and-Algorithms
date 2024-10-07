/*
https://leetcode.com/problems/product-of-array-except-self/description/
 */

import java.util.Arrays;
import java.util.Scanner;

public class _25_LC238_ProductOfArrayExceptSelf {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        int[] ans = productOfArrayExceptSelf(arr);
        for (int i : ans) {
            System.out.println(i);
        }
        int[] ans1 = productOfArrayExceptSelf2(arr);
        for (int i : ans1) {
            System.out.println(i);
        }
    }

    //Brute force
    //TC: O(n) SC: O(n)
    private static int[] productOfArrayExceptSelf(int[] arr) {
        int len = arr.length;
        int[] leftArr = new int[len];
        int[] rightArr = new int[len];

        int left = 1, right = 1;

        for (int i = 0; i < len; i++) {
            leftArr[i] = left;
            rightArr[len - i - 1] = right;
            left *= arr[i];
            right *= arr[len - i - 1];
        }

        int[] res = new int[len];

        for (int i = 0; i < len; i++) {
            res[i] = leftArr[i] * rightArr[i];
        }
        return res;
    }

    //Bidirectional product accumulation
    //TC: O(n) SC: O(1)
    private static int[] productOfArrayExceptSelf2(int[] arr) {
        int len = arr.length;
        int[] res = new int[len];

        int left = 1, right = 1;

        Arrays.fill (res, 1);
        for (int i = 0; i < len; i++) {
            res[i] *= left;
            res[len - i - 1] *= right;
            left *= arr[i];
            right *= arr[len - i - 1];
        }
        return res;
    }
}
