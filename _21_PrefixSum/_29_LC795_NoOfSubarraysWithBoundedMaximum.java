public class _29_LC795_NoOfSubarraysWithBoundedMaximum {

    public static void main(String[] args) {
        int[] nums = {2, 1, 4, 3};
        int left = 2, right = 3;
        System.out.println(numSubarrayBoundedMax(nums, left, right));
    }

    public static int numSubarrayBoundedMax(int[] nums, int left, int right) {
        return count(right, nums) - count(left - 1, nums);
    }

    public static int count (int bound, int[] nums) {
        int count = 0, sum = 0;

        for (int num : nums) {
            count = num <= bound ? count + 1 : 0;
            sum += count;
        }

        return sum;
    }
}
