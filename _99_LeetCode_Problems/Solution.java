//import java.util.*;
//
//class Solution {
//    public int sumOfPower(int[] nums, int k) {
//
//        SubSet s = getTargetSumSubsets(nums, 0, k, new ArrayList<>(), 0);
//        int count = 0;
//        for (List<Integer> subset : s.subsets) {
//            System.out.println("subset" + subset);
//            for (List<Integer> targetSubSet : s.targetSumSubsets) {
//                System.out.println("targetsubset" + targetSubSet);
//                if (new HashSet<>(subset).containsAll(targetSubSet)) {
//                    count++;
//                }
//            }
//        }
//        return count;
//    }
//
//    static class SubSet {
//        public List<List<Integer>> subsets;
//        public List<List<Integer>> targetSumSubsets;
//    }
//
//    public static SubSet getTargetSumSubsets(int[] arr, int idx, int tar, List<Integer> set, int sos) {
//
//        SubSet s = new SubSet();
//        List<List<Integer>> targetSumsubsets = new ArrayList<>();
//        List<List<Integer>> subsets = new ArrayList<>();
//
//        System.out.println("========" + idx);
//
//        if (sos == tar) {
//            subsets.add(new ArrayList<>(set));
//            s.subsets = subsets;
//            targetSumsubsets.add(new ArrayList<>(set));
//            s.targetSumSubsets = targetSumsubsets;
//
//        }
//
//        if (idx == arr.length) {
//            subsets.add(new ArrayList<>(set));
//            s.subsets = subsets;
//            return s;
//        }
//
//        SubSet excludeSet = getTargetSumSubsets(arr, idx + 1, tar, set, sos);
//        set.add(arr[idx]);
//        SubSet includeSet = getTargetSumSubsets(arr, idx + 1, tar, set, sos + arr[idx]);
//
//        subsets.addAll(excludeSet.subsets == null ? new ArrayList<>() : excludeSet.subsets);
//        subsets.addAll(includeSet.subsets == null ? new ArrayList<>() : includeSet.subsets);
//        targetSumsubsets.addAll(excludeSet.targetSumSubsets == null ? new ArrayList<>() : excludeSet.targetSumSubsets);
//        targetSumsubsets.addAll(includeSet.targetSumSubsets == null ? new ArrayList<>() : includeSet.targetSumSubsets);
//        s.subsets = subsets;
//        s.targetSumSubsets = targetSumsubsets;
//        set.remove(set.size() - 1);
//        return s;
//    }
//
//
//    public static void main(String[] args) {
//        Scanner scn = new Scanner(System.in);
//        int n = scn.nextInt();
//        int[] arr = new int[n];
//        for (int i = 0; i < n; i++) {
//            arr[i] = scn.nextInt();
//        }
//        int tar = scn.nextInt();
//        System.out.println(new ServiceNowInterview().sumOfPower(arr, tar));
//    }
//}