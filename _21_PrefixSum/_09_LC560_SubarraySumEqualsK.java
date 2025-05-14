import java.util.HashMap;
import java.util.Map;

public class _09_LC560_SubarraySumEqualsK {

    public static void main(String[] args) {
        int[] arr = {1, 1, 1};
        int k = 2;
        System.out.println(countOfSubarraySumEqualsK(arr, k));
    }

    public static int countOfSubarraySumEqualsK(int[] arr, int k) {
        int sum = 0, result = 0;
        Map<Integer, Integer> prefixSumCount = new HashMap<>();
        prefixSumCount.put(0, 1);

        for (int j : arr) {
            sum += j;
            if (prefixSumCount.containsKey(sum - k)) {
                result += prefixSumCount.get(sum - k);
            }
            prefixSumCount.put(sum, prefixSumCount.getOrDefault(sum, 0) + 1);
        }
        return result;
    }
}
