import java.util.Arrays;

public class _15_LC1991_FindMiddleIndex {

    public static void main(String[] args) {
        int[] nums = {2, 3, -1, 8, 4};
        System.out.println(findMiddleIndex(nums));
    }

    public static int findMiddleIndex(int[] nums) {

        int sum = Arrays.stream(nums).sum();
        int leftSum = 0;
        for (int i = 0; i < nums.length; i++) {
            int rightSum = sum - leftSum - nums[i];
            if (leftSum == rightSum) return i;
            leftSum += nums[i];
        }

        return -1;
    }
}
