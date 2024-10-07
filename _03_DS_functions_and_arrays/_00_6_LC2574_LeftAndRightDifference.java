/*
https://leetcode.com/problems/left-and-right-sum-differences/
 */
public class _00_6_LC2574_LeftAndRightDifference {
    public static void main(String[] args) {

        int[] nums = new int[]{10, 4, 8, 3};
        int n = nums.length;
        for (int i = 1; i < n; i++) {
            nums[i] += nums[i - 1];
        }
        int[] differences = new int[n];
        for (int i = 0; i < n; i++) {
            int firstSum = 0;
            if (i > 0)
                firstSum = nums[i - 1];
            int secondSum = 0;
            if (i < n - 1)
                secondSum = nums[n - 1] - nums[i];
            differences[i] = Math.abs(firstSum - secondSum);
        }
        for (int i : differences) {
            System.out.println(i);
        }
    }
}
