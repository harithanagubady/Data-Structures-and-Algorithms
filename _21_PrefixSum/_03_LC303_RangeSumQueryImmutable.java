import java.util.Arrays;

public class _03_LC303_RangeSumQueryImmutable {

    public static void main(String[] args) {
        int[] arr = {-2, 0, 3, -5, 2, -1};
        int n = arr.length;
        int[][] queries = {{0, 2}, {2, 5}, {0, 5}};

        rangeSumQuery(n, arr, queries);
    }

    private static void rangeSumQuery(int n, int[] arr, int[][] queries) {


        int[] prefixSum = prefixSum(n, arr);
        for (int[] query : queries) {
            int right = prefixSum[query[1]];
            int left = query[0] == 0 ? 0 : prefixSum[query[0] - 1];
            System.out.println(right - left);
        }
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
