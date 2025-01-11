/*
https://leetcode.com/problems/top-k-frequent-elements/description/
 */

import java.util.*;

public class _07_LC347_TopKFrequentNumbers {

    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 2, 2, 2, 3, 3, 3};
        int k = 2;
        System.out.println(frequencySortUsingPriorityQueue(arr, k));
        System.out.println(frequencySortWithBuckets(arr, k));
    }

    //O(nlogn)
    public static List<Integer> frequencySortUsingPriorityQueue(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        maxHeap.addAll(map.entrySet());

        List<Integer> res = new ArrayList<>();

        while (!maxHeap.isEmpty() && res.size() < k) {
            Map.Entry<Integer, Integer> e = maxHeap.poll();
            res.add(e.getKey());
        }

        return res;
    }

    //O(n)
    public static List<Integer> frequencySortWithBuckets(int[] nums, int k) {

        int n = nums.length;
        List<Integer>[] buckets = new ArrayList[n + 1];

        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int i : nums) {
            freqMap.put(i, freqMap.getOrDefault(i, 0) + 1);
        }

        for (int key : freqMap.keySet()) {
            int freq = freqMap.get(key);
            if (buckets[freq] == null) buckets[freq] = new ArrayList<>();
            buckets[freq].add(key);
        }

        List<Integer> ans = new ArrayList<>();
        for (int i = buckets.length - 1; i >= 0 && ans.size() < k; i--) {
            if (buckets[i] == null) continue;
            ans.addAll(buckets[i]);
        }

        return ans;
    }

}
