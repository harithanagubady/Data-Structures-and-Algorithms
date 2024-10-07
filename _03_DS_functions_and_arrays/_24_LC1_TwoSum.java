/*
https://leetcode.com/problems/two-sum/description/
 */

import java.util.HashMap;

public class _24_LC1_TwoSum {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int tar = 9;

        int[] ans = twoSum (arr, tar);
        for (int i : ans) {
            System.out.print(i + "\t");
        }

        System.out.println();
        int[] ans1 = twoSum1 (arr, tar);
        for (int i : ans1) {
            System.out.print(i + "\t");
        }
    }

    //two-pass hash table
    private static int[] twoSum(int[] arr, int tar) {
        HashMap<Integer, Integer> ansMap = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            ansMap.put(arr[i], i);
        }

        for (int i = 0; i < arr.length; i++) {
            int diff = tar - arr[i];
            if (ansMap.containsKey(diff) && ansMap.get(diff) != i) {
                return new int[]{ansMap.get(diff), i};
            }
        }
        return new int[]{};
    }

    //One pass Hash Table
    private static int[] twoSum1(int[] arr, int tar) {
        HashMap<Integer, Integer> ansMap = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            int diff = tar - arr[i];
            if (ansMap.containsKey(diff)) {
                return new int[]{ansMap.get(diff), i};
            }
            ansMap.put(arr[i], i);
        }
        return new int[]{};
    }

}
