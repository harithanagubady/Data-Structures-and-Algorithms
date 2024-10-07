/*
https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/
 */
public class _00_9_LC26_RemoveDuplicatesFromSortedArray {
    public static int removeDuplicates(int[] nums) {
        int len = nums.length;
        if (len <= 1) {
            return len;
        }
        int j = 1;
        for (int i = 1; i < len; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[j] = nums[i];
                j++;
            }
        }
        return j;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 2};
        int k = removeDuplicates(nums);
        System.out.print("{");
        for (int i = 0; i < k; i++) {
            if (i == k - 1) {
                System.out.print(nums[i]);
            } else
                System.out.print(nums[i] + ", ");
        }
        System.out.println("}");
    }
}
