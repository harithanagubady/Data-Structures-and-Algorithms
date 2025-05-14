import java.util.Arrays;

public class _07_LC2389_LongestSubsequenceWithLimitedSum {

    public static void main(String[] args) {

        int[] arr = {4, 5, 2, 1};
        int[] queries = {3, 10, 21};

        System.out.println(Arrays.toString(answerQueries(arr, queries)));
    }
    public static int[] answerQueries(int[] nums, int[] queries) {

        Arrays.sort(nums);
        int m = queries.length;

        for (int i = 1; i < nums.length; i++) {
            nums[i] = nums[i - 1] + nums[i];
        }

        int[] res = new int[m];
        for (int i = 0; i < m; i++) {
            int query = queries[i];
            int j = Arrays.binarySearch(nums, query);
            res[i] = Math.abs(j + 1);
        }

        return res;
    }
}
