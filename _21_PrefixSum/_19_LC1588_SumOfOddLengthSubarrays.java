public class _19_LC1588_SumOfOddLengthSubarrays {

    public static void main(String[] args) {

        int[] arr = {1, 4, 2, 5, 3};
        System.out.println(sumOddLengthSubarrays(arr));
    }

    public static int sumOddLengthSubarrays(int[] arr) {

        int totalSum = 0;
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            totalSum += (((i + 1) * (n - i) + 1) / 2) * arr[i];
        }

        return totalSum;
    }
}
