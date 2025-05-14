import java.util.Arrays;

public class _01_CalculatePrefixSum {

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5};
        int n = arr.length;

        prefixSum1(n, arr);
        prefixSum2(n, arr);
    }

    //O(n) O(n)
    private static void prefixSum1(int n, int[] arr) {
        _03_LC303_RangeSumQueryImmutable.prefixSum(n, arr);
    }

    //O(n) O(1)
    private static void prefixSum2(int n, int[] arr) {
        int prefixSum = 0;
        for (int i = 0; i < n; i++) {
            prefixSum += arr[i];
            System.out.print(prefixSum + " ");
        }
    }
}
