public class _02_RangeSumQuery {

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5};
        int n = arr.length;
        int[] query = {0, 1};

        rangeSumQuery(n, arr, query);
    }

    //O(n) O(n)
    private static void rangeSumQuery(int n, int[] arr, int[] query) {
        int[] prefixSum = new int[n];
        prefixSum[0] = arr[0];
        for (int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i - 1] + arr[i];
        }

        int right = prefixSum[query[1]];
        int left = query[0] == 0 ? 0 : prefixSum[query[0] - 1];
        System.out.println(right - left);
    }
}
