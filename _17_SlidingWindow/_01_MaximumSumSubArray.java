public class _01_MaximumSumSubArray {

    public static void main(String[] args) {
        int[] arr = {2,1,5,1,3,2};
        int k = 3;

        int windowSum = 0;
        int maxSum = Integer.MIN_VALUE;
        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            windowSum += arr[windowEnd];
            if (windowEnd >= k - 1) {

            }
            //maxSum = Math.max(sum, maxSum);
        }
        System.out.println(maxSum);
    }
}
