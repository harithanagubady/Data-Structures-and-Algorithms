/*
https://leetcode.com/problems/divide-array-into-arrays-with-max-difference/description/
 */

import java.util.Arrays;

public class _05_LC2966_DivideArrayWithMaxDiff {

    public static void main(String[] args) {
        int[] nums = {4,2,9,8,2,12,7,12,10,5,8,5,5,7,9,2,5,11};
        int[] nums1 = {4, 8, 3, 120, 350, 88};
        if (nums1.length % 3 != 0) {
            System.out.println("invalid input");
            return;
        }
        int[][] ans = divideArray(nums1, 14);
        for (int[] ar : ans) {
            System.out.println(Arrays.toString(ar));
        }
    }

    public static int[][] divideArray(int[] nums, int k) {
        int n = nums.length;
        int[][] result = new int[n/3][3];
        Arrays.sort(nums);
        int idx = 0;
        for (int i = 0; i < n - 2; i += 3) {
            if (nums[i + 2] - nums[i] <= k) {
                result[idx++] = new int[]{nums[i], nums[i + 1], nums[i + 2]};
            } else {
                return new int[][]{};
            }
        }
        return result;
    }
}
