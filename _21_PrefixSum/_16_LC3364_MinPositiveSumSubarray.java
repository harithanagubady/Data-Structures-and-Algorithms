import java.util.List;

public class _16_LC3364_MinPositiveSumSubarray {

    public static void main(String[] args) {
        List<Integer> nums = List.of(3, -2, 1, 4);
        int l = 2, r = 3;
        System.out.println(minimumSumSubarray(nums, l, r));
    }

    public static int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int minSum = Integer.MAX_VALUE;

        for (int k = l; k <= r; k++) {
            int sum = 0;
            for (int i = 0; i < k; i++) {
                sum += nums.get(i);
            }

            if (sum > 0) {
                minSum = Math.min(minSum, sum);
            }

            for (int i = k; i < nums.size(); i++) {
                sum += nums.get(i);
                sum -= nums.get(i - k);

                if (sum > 0) {
                    minSum = Math.min(minSum, sum);
                }
            }
        }
        return minSum == Integer.MAX_VALUE ? -1 : minSum;
    }
}
