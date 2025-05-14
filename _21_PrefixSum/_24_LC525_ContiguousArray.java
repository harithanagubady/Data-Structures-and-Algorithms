import java.util.HashMap;

public class _24_LC525_ContiguousArray {

    public static void main(String[] args) {

        int[] nums = {0, 1};
        System.out.println(findMaxLength(nums));
    }

    public static int findMaxLength(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) nums[i] = -1;
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0, maxLen = 0;
        map.put(sum, -1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum)) {
                maxLen = Math.max (maxLen, i - map.get(sum));
            } else {
                map.put(sum, i);
            }
        }

        return maxLen;
    }
}
