import java.util.ArrayList;
import java.util.List;

/*
https://leetcode.com/problems/combination-sum/description/
 */
public class _07_CombinationSum {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        findCombinations(candidates, target, new ArrayList<>(), 0);
        return res;
    }

    public void findCombinations(int[] candidates, int target, List<Integer> set, int start) {
        if (0 == target) {
            res.add(new ArrayList<>(set));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            if (target < candidates[i]) continue;
            set.add(candidates[i]);
            findCombinations(candidates, target - candidates[i], set, i);
            set.remove(set.size() - 1);
        }

    }

    public static void main(String[] args) {
        int[] candidates = {3, 2, 5};
        int tar = 8;
        List<List<Integer>> res = new _07_CombinationSum().combinationSum(candidates, tar);
        System.out.println(res);
    }
}
