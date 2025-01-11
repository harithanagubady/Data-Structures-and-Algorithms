/*
https://leetcode.com/problems/top-k-frequent-words/description/
 */

import java.util.*;

public class _08_LC692_TopKFrequentWords {

    public static void main(String[] args) {
        String[] words = {"leetcode", "i", "love", "i", "love", "coding", "coding", "coding"};
        //String[] words = {"a", "aa", "aaa"};
        int k = 2;

        List<String> res = topKFrequentQuickSelect(words, k);
        System.out.println(res);
    }

    //O(nlogn), O(n)
    public static List<String> topKFrequentWithSorting(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();

        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        List<Map.Entry<String, Integer>> l = new LinkedList<>(map.entrySet());

        l.sort((a, b) -> {
            int freq1 = a.getValue(), freq2 = b.getValue();
            String word1 = a.getKey(), word2 = b.getKey();
            if (freq1 != freq2) {
                return freq2 - freq1;
            } else {
                return word1.compareTo(word2);
            }
        });

        List<String> ans = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            ans.add(l.get(i).getKey());
        }
        return ans;
    }

    //O(nlogn + klogn) = O(nlogn) &  O(n)
    public static List<String> topKFrequentWithMaxHeap(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();

        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        PriorityQueue<Map.Entry<String, Integer>> maxHeap = new PriorityQueue<>((a, b) -> {
            int freq1 = a.getValue(), freq2 = b.getValue();
            String word1 = a.getKey(), word2 = b.getKey();
            if (freq1 != freq2) {
                return freq2 - freq1;
            } else {
                return word1.compareTo(word2);
            }
        });

        for (Map.Entry<String, Integer> e : map.entrySet()) {
            maxHeap.offer(e);
        }

        List<String> ans = new LinkedList<>();
        for (int i = 0; i < k && !maxHeap.isEmpty(); i++) {
            ans.add(maxHeap.poll().getKey());
        }

        return ans;
    }

    //O(nlogk) O(k)
    public static List<String> topKFrequentWithMinHeap(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();

        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        Comparator<Map.Entry<String, Integer>> comparator = (a, b) -> {
            int freq1 = a.getValue(), freq2 = b.getValue();
            String word1 = a.getKey(), word2 = b.getKey();
            if (freq1 != freq2) {
                return freq1 - freq2;
            } else {
                return word2.compareTo(word1);
            }
        };
        PriorityQueue<Map.Entry<String, Integer>> minHeap = new PriorityQueue<>(comparator);

        for (Map.Entry<String, Integer> e : map.entrySet()) {
            if (minHeap.size() < k) {
                minHeap.offer(e);
            } else {
                if (comparator.compare(e, minHeap.peek()) > 0) {
                    //remove min freq element and add max freq element
                    minHeap.poll();
                    minHeap.offer(e);
                }

            }
        }

        List<String> ans = new LinkedList<>();
        for (int i = 0; i < k && !minHeap.isEmpty(); i++) {
            ans.add(0, minHeap.poll().getKey());
        }

        return ans;
    }

    //O(nm) & O(nm), m is constant time to construct trie
    public static List<String> topKFrequentWithBucketAndTrie(String[] words, int k) {
        int n = words.length;
        Trie[] buckets = new Trie[n];
        Map<String, Integer> freqMap = new HashMap<>();

        for (String word : words) {
            freqMap.put(word, freqMap.getOrDefault(word, 0) + 1);
        }

        for (Map.Entry<String, Integer> e : freqMap.entrySet()) {
            String word = e.getKey();
            int freq = e.getValue();
            if (buckets[freq] == null) buckets[freq] = new Trie();
            buckets[freq].addWord(word);
        }

        List<String> ans = new LinkedList<>();
        for (int i = buckets.length - 1; i >= 0 && ans.size() < k; i--) {
            if (buckets[i] == null) continue;
            buckets[i].getWords(buckets[i], ans);
            while (ans.size() > k) {
                ans.remove(ans.size() - 1);
            }
        }
        return ans;
    }

    //O(nlogn) & O(n)
    public static List<String> topKFrequentWithBucketAndTreeMap(String[] words, int k) {
        int n = words.length;
        Map<String, Integer> freqMap = new HashMap<>();

        for (String word : words) {
            freqMap.put(word, freqMap.getOrDefault(word, 0) + 1);
        }
        TreeMap<String, Integer>[] buckets = new TreeMap[n];

        for (Map.Entry<String, Integer> e : freqMap.entrySet()) {
            String word = e.getKey();
            int freq = e.getValue();
            if (buckets[freq] == null) buckets[freq] = new TreeMap<>(String::compareTo);
            buckets[freq].put(word, freq);
        }

        List<String> ans = new LinkedList<>();
        for (int i = buckets.length - 1; i >= 0 && ans.size() < k; i--) {
            if (buckets[i] == null) continue;
            TreeMap<String, Integer> temp = buckets[i];
            while (temp.size() > 0 && ans.size() < k) {
                ans.add(temp.pollFirstEntry().getKey());
            }
        }
        return ans;
    }

    //O(n + klogk) -> k log k to sort k elements & O(n) for quickselect in worst case
    public static List<String> topKFrequentQuickSelect(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        Map.Entry<String, Integer>[] entrys = new Map.Entry[map.size()];
        int index = 0;
        for (Map.Entry<String, Integer> e : map.entrySet()) {
            entrys[index] = e;
            index++;
        }
        //do quick select
        int start = 0;
        int end = entrys.length - 1;
        int mid = 0;
        while (start <= end) {
            mid = partition(entrys, start, end);
            if (mid == k - 1) {
                break;
            } else if (mid < k - 1) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        List<String> ans = new LinkedList<>();
        List<Map.Entry<String, Integer>> l = new LinkedList<>(Arrays.asList(entrys).subList(0, mid + 1));
        //still need to sort these K words, because we only know they are in result, but not in right order
        l.sort(new MyComparator());
        for (Map.Entry<String, Integer> e : l) {
            ans.add(e.getKey());
        }
        return ans;
    }

    private static int partition(Map.Entry<String, Integer>[] entrys, int start, int end) {
        int left = start + 1;
        int right = end;
        MyComparator myComparator = new MyComparator();

        while (true) {
            while (left <= end && myComparator.compare(entrys[left], entrys[start]) <= 0) {
                left++;
            }

            while (right >= start + 1 && myComparator.compare(entrys[right], entrys[start]) > 0) {
                right--;
            }
            if (left > right) {
                break;
            }
            swap(entrys, left, right);
        }
        swap(entrys, start, right);
        return right;
    }

    private static void swap(Map.Entry<String, Integer>[] entrys, int i, int j) {
        Map.Entry<String, Integer> a = entrys[i];
        entrys[i] = entrys[j];
        entrys[j] = a;
    }


    static class MyComparator implements Comparator<Map.Entry<String, Integer>> {

        public int compare(Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2) {
            String word1 = e1.getKey();
            int freq1 = e1.getValue();
            String word2 = e2.getKey();
            int freq2 = e2.getValue();
            if (freq1 != freq2) {
                return freq2 - freq1; //ensures e2 > e1 => returns 1 if e2 > e1 else -1 if e2 < e1 // swap if -1
            } else {
                return word1.compareTo(word2);
            }
        }
    }


    static class Trie {
        Trie[] children;
        String word;

        public Trie() {
            this.children = new Trie[26];
            this.word = null;
        }

        public void addWord(String word) {
            Trie curr = this;

            for (char ch : word.toCharArray()) {
                if (curr.children[ch - 'a'] == null) {
                    curr.children[ch - 'a'] = new Trie();
                }
                curr = curr.children[ch - 'a'];
            }
            curr.word = word;
        }

        public void getWords(Trie node, List<String> ans) {
            if (node == null) return;

            if (node.word != null) ans.add(node.word);

            for (int i = 0; i <= 25; i++) {
                if (node.children[i] != null) {
                    getWords(node.children[i], ans);
                }
            }
        }
    }
}
