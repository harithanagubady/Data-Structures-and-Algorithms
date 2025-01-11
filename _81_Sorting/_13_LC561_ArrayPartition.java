import java.util.Arrays;

public class _13_LC561_ArrayPartition {

    public static void main(String[] args) {
        int[] nums = {1, 4, 3, 2};
        System.out.println(arrayPairSum(nums));

        int[] nums1 = {1, 4, 3, 2};
        System.out.println(arrayPairSum2(nums1));
    }

    //O(nlogn)
    public static int arrayPairSum(int[] nums) {
        int ans = 0;
        Arrays.sort(nums);
        for (int i = nums.length - 2; i >= 0; i -= 2) {
            ans += nums[i];
        }
        return ans;
    }

    //Counting Sort - O(n)
    public static int arrayPairSum2(int[] nums) {
        int[] count = new int[20001];
        for (int num : nums) {
            count[num + 10000]++;
        }

        boolean add = false;
        int idx = 20000;
        int sum = 0;
        while (idx >= 0){
            while (count[idx]-- > 0) {
                if (add) sum += (idx - 10000);
                add = !add;
            }
            idx--;
        }
        return sum;
    }

}
