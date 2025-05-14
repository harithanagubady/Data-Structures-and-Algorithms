import java.util.HashMap;

public class _10_LC974_CountOfSubarraySumsDivisibleByK {

    public static void main(String[] args) {
        int[] arr = {4, 5, 0, -2, -3, 1};
        int k = 5;
        System.out.println(subarraysDivByK(arr, k));
    }

    private static int subarraysDivByK(int[] arr, int k) {
        int[] map = new int[k]; //sum, count
        map[0] = 1;
        int count = 0;
        int sum = 0;
        for (int j : arr) {
            sum = (sum + j) % k;
            if (sum < 0) sum += k;
            count += map[sum];
            map[sum]++;
        }
        return count;
    }
}
