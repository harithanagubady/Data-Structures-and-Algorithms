/*
https://leetcode.com/problems/contains-duplicate/description/
 */

import java.util.Arrays;
import java.util.HashSet;

public class _00_5_LC217_ContainsDuplicate {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 1};
        System.out.println(containsDuplicateSorting(nums));
        System.out.println(containsDuplicateHashing(nums));
    }

    private static boolean containsDuplicateHashing(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                return true;
            } else {
                set.add(num);
            }
        }
        return false;
    }

    public static boolean containsDuplicateSorting(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                return true;
            }
        }
        return false;
    }
}
