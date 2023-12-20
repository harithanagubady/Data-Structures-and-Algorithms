import java.util.*;

public class _496_Solution {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>(); // Map to store the next greater elements
        Deque<Integer> stack = new ArrayDeque<>(); // Stack to keep track of elements

        for (int i = nums2.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums2[i] > stack.peek()) {
                stack.pop(); // Remove elements smaller than the current element
            }
            if (!stack.isEmpty()) {
                map.put(nums2[i], stack.peek()); // Store the next greater element for each element in nums2
            }
            stack.push(nums2[i]); // Push current element to the stack
        }

        int[] result = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            result[i] = map.getOrDefault(nums1[i], -1); // Retrieve next greater elements for nums1 from map
        }
        return result;
    }

    // Example usage:
    public static void main(String[] args) {
        _496_Solution solution = new _496_Solution();
        int[] nums1 = {4, 1, 2};
        int[] nums2 = {1, 3, 4, 2};

        int[] result = solution.nextGreaterElement(nums1, nums2);
        System.out.println("Next greater elements: " + Arrays.toString(result));
    }
}
