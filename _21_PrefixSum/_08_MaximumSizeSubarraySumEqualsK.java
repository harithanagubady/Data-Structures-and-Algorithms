import java.util.HashMap;

public class _08_MaximumSizeSubarraySumEqualsK {

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, -2, 5};
        int k = 5;
        System.out.println(maxSubArrayLen(arr, k));

        arr = new int[] {3, 4, 7, 2, -3, 1, 4, 2};
        k = 7;
        System.out.println(maxSubArrayLen(arr, k));
    }

    private static int maxSubArrayLen(int[] arr, int k) {

        int n = arr.length;

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        int sum = 0;
        int max = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            if (map.containsKey(sum - k)) {
                //System.out.println(i + " " + map.get(sum - k));
                int len = i - map.get(sum - k);
                max = Math.max(max, len);
            }
            if (!map.containsKey(sum)) map.put(sum, i); //maintaining longest subarray
        }
        //System.out.println(map);
        return max;
    }
}
