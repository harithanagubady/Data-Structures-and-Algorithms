/*
https://leetcode.com/problems/two-sum/description/
 */

import java.util.HashMap;

public class _00_8_LC1_TwoSum {

    public static void main(String[] args) {
        int[] nums = new int[] {2, 7, 11, 15};
        int target = 9;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (map.containsKey(diff)) {
                System.out.println(map.get(diff)+ " " + i);
                return;
            }
            map.put(nums[i], i);
        }
    }
}
