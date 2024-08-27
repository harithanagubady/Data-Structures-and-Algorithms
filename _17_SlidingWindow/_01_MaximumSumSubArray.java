public class _01_MaximumSumSubArray {

    public static void main(String[] args) {
        int[] arr = {2, 1, 5, 1, 3, 2};
        int k = 3;

        //calculate Prefix Sums
        findMaxSum2(arr, k);
        //calculate one prefix sum
        findMaxSum(arr, k);
    }

    //inefficient approach
    private static void findMaxSum2(int[] arr, int k) {
        int N = arr.length;
        int[] prefixSums = new int[N];
        prefixSums[0] = arr[0];
        for (int i = 1; i < N; i++) {
            prefixSums[i] = prefixSums[i - 1] + arr[i];
        }

        int maxSum = prefixSums[k - 1];
        for (int j = k; j < N; j++) {
            int currSum = prefixSums[j] - prefixSums[j - k];
            if (currSum > maxSum) {
                maxSum = currSum;
            }
        }
        System.out.println(maxSum);
    }

    //Using Sliding Window Approach -> non-shrinkable template
    //grow the window until the condition (length should be k) is met.
    //Shift the window and calculate sum of each window
    private static void findMaxSum(int[] arr, int k) {
        int N = arr.length;
        int windowSum = 0;
        int maxSum = 0;
        int i = 0;
        for (int j = 0; j < N; j++) {
            windowSum += arr[j];
            if (j >= k - 1) {
                maxSum = Math.max(maxSum, windowSum);
                windowSum -= arr[i++];
            }
        }
        System.out.println(maxSum);
    }

}
