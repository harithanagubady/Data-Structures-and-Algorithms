public class _18_LC3427_SumOfVariableLengthSubarrays {
    public static void main(String[] args) {
        int[] nums = {2, 3, 1};
        System.out.println(subarraySum(nums));
    }

    public static int subarraySum(int[] nums) {
        int[] p = new int[nums.length];
        p[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            p[i] = p[i - 1] + nums[i];
        }

        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            int start = Math.max(0, i - nums[i]);
            if (start > 0)
                sum += p[i] - p[start - 1];
            else
                sum += p[i];
        }

        return sum;
    }
}
