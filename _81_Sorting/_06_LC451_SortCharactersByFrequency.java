/*
https://leetcode.com/problems/sort-characters-by-frequency/description/
 */

import java.util.*;

public class _06_LC451_SortCharactersByFrequency {

    public static void main(String[] args) {
        String s = "eeeccckkaa55555";
        System.out.println(frequencySortUsingPQMaintainInsertionOrder(s));
    }

    //O(nlogn)
    public static String frequencySortUsingPQMaintainInsertionOrder(String s) {
        Map<Character, int[]> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!map.containsKey(ch)) map.put(ch, new int[]{1, i}); //{frequency, index}, index only for additional
                // condition -> maintain input order for same frequency
            else {
                int[] freq = map.get(ch);
                freq[0]++;
                map.put(ch, freq);
            }
        }

        PriorityQueue<Map.Entry<Character, int[]>> maxHeap = new PriorityQueue<>(
                (a, b) -> a.getValue()[0] == b.getValue()[0]
                                ? a.getValue()[1] - b.getValue()[1] : b.getValue()[0] - a.getValue()[0]
        );
        maxHeap.addAll(map.entrySet());

        StringBuilder sb = new StringBuilder();
        while (!maxHeap.isEmpty()) {
            Map.Entry<Character, int[]> e = maxHeap.poll();
            sb.append(String.valueOf(e.getKey()).repeat(e.getValue()[0]));
        }

        return sb.toString();
    }

    //O(nlogn)
    public static String frequencySortUsingPriorityQueue(String s) {

        Map<Character, Integer> map = new HashMap<>();

        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        maxHeap.addAll(map.entrySet());

        StringBuilder sb = new StringBuilder();

        while (!maxHeap.isEmpty()) {
            Map.Entry<Character, Integer> e = maxHeap.poll();
            sb.append(String.valueOf(e.getKey()).repeat(Math.max(0, e.getValue())));
        }

        return sb.toString();
    }

    public static String frequencySortWithBuckets(String s) {

        Map<Character, Integer> map = new HashMap<>();

        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        List<Character>[] buckets = new ArrayList[s.length() + 1];

        for (char key : map.keySet()) {
            int freq = map.get(key);
            if (buckets[freq] == null) buckets[freq] = new ArrayList<>();
            buckets[freq].add(key);
        }

        StringBuilder sb = new StringBuilder();

        for (int pos = buckets.length - 1; pos >= 0; pos--) {
            if (buckets[pos] == null) continue;
            for (char c : buckets[pos]) {
                for (int i = 0; i < pos; i++) sb.append(c);
            }
        }

        return sb.toString();
    }
}
