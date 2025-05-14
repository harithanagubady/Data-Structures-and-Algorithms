public class _22_LC1413_MinValToGetPositiveSum {

    public static void main(String[] args) {

        int[] nums = {-3, 2, -3, 4, 2};
        System.out.println(minStartValue(nums));
    }

    public static int minStartValue(int[] nums) {
        int minPrefix = 0;
        int s = 0;
        for (int i = 0; i < nums.length; i++) {
            s += nums[i];
            minPrefix = Math.min(minPrefix, s);
        }
        return 1 - minPrefix;
    }
}
