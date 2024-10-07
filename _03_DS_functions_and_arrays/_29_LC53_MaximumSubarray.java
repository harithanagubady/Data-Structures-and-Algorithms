/*
https://leetcode.com/problems/maximum-subarray/description/
 */
public class _29_LC53_MaximumSubarray {

    public static void main(String[] args) {
        int[] arr = {-2, 8, 5, 10, -9};

        int e = maxSubarray(arr);
        System.out.println(e);
    }

    private static int maxSubarray(int[] arr) {

        int currSum = arr[0];
        int globalSum = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (currSum < 0) {
                currSum = arr[i];
            } else {
                currSum += arr[i];
            }
            if (globalSum < currSum) {
                globalSum = currSum;
            }
        }
        return globalSum;
    }
}
