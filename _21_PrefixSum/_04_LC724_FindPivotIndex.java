public class _04_LC724_FindPivotIndex {

    public static void main(String[] args) {

        int[] arr = {1, 7, 3, 6, 5, 6};
        System.out.println(pivotIndex1(arr));
        System.out.println(pivotIndex2(arr));
    }

    //O(n) O(n)
    public static int pivotIndex1(int[] nums) {
        int[] prefixSum = prefixSum(nums.length, nums);
        if (prefixSum[prefixSum.length - 1] - prefixSum[0] == 0) return 0;
        for (int i = 1; i < nums.length; i++) {
            if (prefixSum[i - 1] == prefixSum[prefixSum.length - 1] - prefixSum[i])
                return i;
        }
        return -1;
    }

    //O(n) O(1)
    public static int pivotIndex2(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        int leftSum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (sum == 2*leftSum + nums[i]) return i;
            leftSum += nums[i];
        }
        return -1;
    }

    static int[] prefixSum(int n, int[] arr) {
        int[] prefixSum = new int[n];
        prefixSum[0] = arr[0];
        for (int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i - 1] + arr[i];
        }
        return prefixSum;
    }
}
