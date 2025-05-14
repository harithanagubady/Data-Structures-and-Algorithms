import java.util.HashMap;

public class _11_LC930_BinarySubarraysWithSum {

    public static void main(String[] args) {

        int[] arr = {1, 0, 1, 0, 1};
        int k = 2;
        System.out.println(binarySubarraysWithSum1(arr, k));
        System.out.println(binarySubarraysWithSum2(arr, k));
    }

    // O(n) O(n)
    private static int binarySubarraysWithSum1(int[] arr, int k) {

        int n = arr.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0;
        int count = 0;
        for (int j : arr) {
            sum += j;
            count += map.getOrDefault(sum - k, 0);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }

    //O(n) O(1)
    private static int binarySubarraysWithSum2(int[] arr, int k) {
        return atMost(arr, k) - atMost(arr, k - 1);
    }

    private static int atMost(int[] arr, int k) {
        int n = arr.length;
        int count = 0;
        int start = 0;
        for (int i = 0; i < n; i++) {
            k -= arr[i];
            while (k < 0) {
                k += arr[start++];
            }
            count += i - start + 1;
        }
        return count;
    }
}
