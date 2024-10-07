/*
https://leetcode.com/problems/running-sum-of-1d-array/
 */
public class _00_4_LC1480_RunningSum {

    public static void runningSum(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[] {1, 2, 3, 4};
        runningSum(arr);
        for (int i : arr) {
            System.out.println(i);
        }
    }
}
