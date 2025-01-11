import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
https://leetcode.com/problems/sort-array-by-increasing-frequency/description/
 */
public class _02_LC1636_SortByFrequency {

    public static int[] frequencySort(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        Arrays.stream(nums).forEach(n -> map.put(n, map.getOrDefault(n, 0) + 1));

        return Arrays.stream(nums).boxed()
                .sorted((a, b) -> map.get(a) != map.get(b) ? map.get(a) - map.get(b) : b - a)
                .mapToInt(n -> n)
                .toArray();
        //increasing order of frequency => map.get(a) - map.get(b)
        //same frequency => sort in decreasing order => b - a
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 2, 2, 3};
        System.out.println(Arrays.toString(frequencySort(arr)));
        int[] arr1 = {1, 1, 2, 2, 2, 3};
        System.out.println(Arrays.toString(frequencySort2(arr1)));
    }

    //using mergeSort
    public static int[] frequencySort2(int[] nums) {
        // Step 1: Count frequency
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        // Step 2: Use merge sort for custom sorting
        mergeSort(nums, 0, nums.length - 1, freqMap);

        return nums;
    }

    // Merge Sort Function
    private static void mergeSort(int[] nums, int left, int right, Map<Integer, Integer> freqMap) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(nums, left, mid, freqMap);
            mergeSort(nums, mid + 1, right, freqMap);
            merge(nums, left, mid, right, freqMap);
        }
    }

    // Merge Function
    private static void merge(int[] nums, int left, int mid, int right, Map<Integer, Integer> freqMap) {
        // Temporary arrays to hold the values
        int[] leftArray = Arrays.copyOfRange(nums, left, mid + 1);
        int[] rightArray = Arrays.copyOfRange(nums, mid + 1, right + 1);

        int i = 0, j = 0, k = left;
        while (i < leftArray.length && j < rightArray.length) {
            // Comparing frequencies and values for sorting
            if (freqMap.get(leftArray[i]) < freqMap.get(rightArray[j]) ||
                    (freqMap.get(leftArray[i]).equals(freqMap.get(rightArray[j])) && leftArray[i] > rightArray[j])) {
                nums[k] = leftArray[i];
                i++;
            } else {
                nums[k] = rightArray[j];
                j++;
            }
            k++;
        }

        // Copy the remaining elements of leftArray, if any
        while (i < leftArray.length) {
            nums[k] = leftArray[i];
            i++;
            k++;
        }

        // Copy the remaining elements of rightArray, if any
        while (j < rightArray.length) {
            nums[k] = rightArray[j];
            j++;
            k++;
        }
    }
}
