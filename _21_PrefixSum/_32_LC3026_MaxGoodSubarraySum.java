import java.util.HashMap;

public class _32_LC3026_MaxGoodSubarraySum {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6};
        int k = 1;
        System.out.println(maximumSubarraySum(nums, k));
        nums = new int[]{-1, 3, 2, 4, 5};
        k = 3;
        System.out.println(maximumSubarraySum(nums, k));
    }

    public static long maximumSubarraySum(int[] nums, int k) {
        HashMap<Integer, Long> map = new HashMap<>();

        long maxEnding = Long.MIN_VALUE;
        int n = nums.length;
        long prefixSum = 0;
        for (int i = 0; i < n; i++) {

            if (map.getOrDefault(nums[i], Long.MAX_VALUE) > prefixSum)
                map.put(nums[i], prefixSum);

            prefixSum += nums[i];

            int sum = nums[i] + k;
            if (map.containsKey(sum)) maxEnding = Math.max(maxEnding, prefixSum - map.get(sum));

            sum = nums[i] - k;
            if (map.containsKey(sum)) maxEnding = Math.max(maxEnding, prefixSum - map.get(sum));
        }

        return maxEnding == Long.MIN_VALUE ? 0 : maxEnding;
    }
}
