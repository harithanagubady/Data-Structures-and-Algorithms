public class _20_LC3028_AntOnBoundary {

    public static void main(String[] args) {
        int[] arr = {2, 3, -5};
        System.out.println(returnToBoundaryCount(arr));
    }

    public static int returnToBoundaryCount(int[] nums) {
        int sum = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum == 0) count++;
        }
        return count;
    }
}
