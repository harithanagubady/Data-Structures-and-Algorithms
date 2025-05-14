public class _17_LC3432_CountPartitionsWithEvenSumDiff {

    public static void main(String[] args) {

        int[] nums = {10, 10, 3, 7, 6};
        System.out.println(countPartitions(nums));
    }
    public static int countPartitions(int[] nums) {

        int[] p = new int[nums.length];
        p[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            p[i] = p[i - 1] + nums[i];
        }
        int sum = p[nums.length - 1];
        int count = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if ((sum - 2 * p[i]) % 2 == 0) count++;
        }
        return count;
    }
}
