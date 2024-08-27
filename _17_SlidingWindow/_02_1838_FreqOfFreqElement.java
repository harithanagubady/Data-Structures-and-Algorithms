import java.util.Arrays;

public class _02_1838_FreqOfFreqElement {

    //Shrinkable Template
    public int maxFrequency(int[] nums, int k) {
        int i = 0, j = 0, N = nums.length;
        long sum = 0;
        long maxFreq = 1;
        Arrays.sort(nums);
        for (; j < N; j++) {
            sum += nums[j];
            while (((j - i + 1L) * nums[j]) - sum > k) {
                sum -= nums[i++];
            }
            maxFreq = Math.max(maxFreq, j - i + 1L);
        }
        return (int) maxFreq;
    }

    //Non-Shrinkable Template
    public int maxFrequency1(int[] nums, int k) {
        int i = 0, j = 0, N = nums.length;
        long sum = 0;
        long maxFreq = 1;
        Arrays.sort(nums);
        for (; j < N; j++) {
            sum += nums[j];
            if (((j - i + 1L) * nums[j]) - sum > k) {
                sum -= nums[i++];
            }
        }
        return j - i;
    }

    public static void main(String[] args) {
        _02_1838_FreqOfFreqElement o = new _02_1838_FreqOfFreqElement();
        int[] nums = {3, 6, 9};
        System.out.println(o.maxFrequency(nums, 2));
        int[] nums1 = {1, 2, 4};
        System.out.println(o.maxFrequency1(nums1, 5));
    }
}