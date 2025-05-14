import java.util.Arrays;

public class _12_LC1685_SumOfAbsDiffInSortedArray {

    public static void main(String[] args) {
        int[] nums = {1, 3, 6};
        int[] result = getSumAbsoluteDifferences(nums);
        System.out.println(Arrays.toString(result));
    }

    public static int[] getSumAbsoluteDifferences(int[] nums) {

        int n = nums.length;
        int[] prefixSum = new int[n + 1];

        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }

        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            int leftSum = prefixSum[i];
            int rightSum = prefixSum[n] - prefixSum[i + 1];
            result[i] = (i * nums[i] - leftSum) + (rightSum - (n - i - 1) * nums[i]);
        }

        return result;
    }
}
