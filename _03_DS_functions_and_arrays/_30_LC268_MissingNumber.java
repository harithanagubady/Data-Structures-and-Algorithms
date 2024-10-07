import java.util.Arrays;

/*
https://leetcode.com/problems/missing-number/description/
 */
public class _30_LC268_MissingNumber {

    public static int missingNumber(int[] nums) {
        Arrays.sort(nums);
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > mid) {
                right = mid;
            } else left = mid + 1;
        }
        return left;
    }

    public static int missingNumber1(int[] nums) {
        int n = nums.length;
        int sum = n * (n + 1) / 2;
        for (int num : nums) {
            sum -= num;
        }
        return sum;
    }

    public static int missingNumber3(int[] nums) {
        int n = nums.length;
        int res = n;
        for (int i = 0; i < n; i++) {
            res = res ^ i ^ nums[i];
        }
        return res;
    }
    public static void main(String[] args) {
        int[] arr = new int[] {1, 0, 2}; //missing 3
        System.out.println(missingNumber(arr));
        System.out.println(missingNumber1(arr));
        System.out.println(missingNumber3(arr));
    }
}
