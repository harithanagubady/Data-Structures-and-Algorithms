/*
https://leetcode.com/problems/reduction-operations-to-make-the-array-elements-equal/
 */

import java.util.Arrays;

public class _04_LC1887_ReductionOperations {

    public static void main(String[] args) {
        int[] arr = {3, 5, 5, 2};
        System.out.println(reductionOperations(arr));
    }

    public static int reductionOperations(int[] nums) {
        int ans = 0;
        Arrays.sort(nums);
        for (int i = nums.length - 1; i >= 1; i--) {
            if (nums[i] != nums[i - 1]) {
                ans += (nums.length - i);
            }
        }
        return ans;
    }
}
