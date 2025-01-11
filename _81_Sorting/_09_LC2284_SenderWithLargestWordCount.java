/*
https://leetcode.com/problems/sender-with-largest-word-count/description/
 */

import java.util.*;

public class _09_LC2284_SenderWithLargestWordCount {

    public static void main(String[] args) {
//        String[] messages = {"Hello userTwooo", "Hi userThree", "Wonderful day Alice", "Nice day userThree"};
//        String[] senders = {"Alice", "userTwo", "userThree", "Alice"};

        String[] messages = {"How is leetcode for everyone", "Leetcode is useful for practice", "Hi My Name is Ramya"};
        String[] senders = {"charlie", "Bob", "Charlie"};
        System.out.println(largestWordCountWithoutSort(messages, senders));
    }

    //O(n log n)
    public static String largestWordCount(String[] messages, String[] senders) {
        Map<String, Integer> freqMap = new HashMap<>();
        for (int i = 0; i < senders.length; i++) {
            String[] words = messages[i].split(" ");
            freqMap.put(senders[i], freqMap.getOrDefault(senders[i], 0) + words.length);
        }

        Comparator<Map.Entry<String, Integer>> c = (a, b) -> b.getValue().compareTo(a.getValue()) == 0 ?
                b.getKey().compareTo(a.getKey()) : b.getValue().compareTo(a.getValue());

        List<Map.Entry<String, Integer>> l = new LinkedList<>(freqMap.entrySet());
        l.sort(c);

        return l.get(0).getKey();
    }

    //O(n)
    public static String largestWordCountWithoutSort(String[] messages, String[] senders) {
        Map<String, Integer> freqMap = new HashMap<>();
        for (int i = 0; i < senders.length; i++) {
            String[] words = messages[i].split(" ");
            freqMap.put(senders[i], freqMap.getOrDefault(senders[i], 0) + words.length);
        }

        String name = "";
        int maxFreq = 0;
        for (Map.Entry<String, Integer> e : freqMap.entrySet()) {
            int freq = e.getValue();
            String word = e.getKey();
            if (maxFreq < freq) {
                maxFreq = freq;
                name = word;
            } else if (maxFreq == freq && name.compareTo(word) < 0) {
                name = word;
            }
        }

        return name;
    }
}
