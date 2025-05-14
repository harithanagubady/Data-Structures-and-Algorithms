import java.util.Arrays;

public class _06_DifferenceArray {

    public static void main(String[] args) {
        int[] arr = {10, 5, 20, 40};

        int[][] queries = {{1, 0, 1, 10}, {2}, {1, 1, 3, 20}, {1, 2, 2, 30}, {2}};

        solution(arr, queries);
    }

    private static void solution(int[] arr, int[][] queries) {
        int n = arr.length;
        int[] diff = differenceArray(arr, n);
        for (int[] query : queries) {
            if (query[0] == 1) {
                diff[query[1]] += query[3];
                if (query[2] < n - 1) diff[query[2] + 1] -= query[3];
            } else {
                int[] ar = new int[n];
                ar[0] = diff[0];
                for (int i = 1; i < n; i++) {
                    ar[i] = ar[i - 1] + diff[i];
                }
                System.out.println(Arrays.toString(ar));
            }
        }
    }

    private static int[] differenceArray(int[] arr, int n) {
        int[] diff = new int[n];

        diff[0] = arr[0];
        for (int i = 1; i < n; i++) {
            diff[i] = arr[i] - arr[i - 1];
        }
        return diff;
    }
}


