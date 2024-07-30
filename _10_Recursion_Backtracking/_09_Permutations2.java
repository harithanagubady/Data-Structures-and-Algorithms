import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/*
https://leetcode.com/problems/permutations-ii/
 */
public class _09_Permutations2 {

    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<Integer> set = new ArrayList<>();
        generatePermutations(nums, set, 0, new HashSet<>());
        return res;
    }

    private void generatePermutations(int[] nums, List<Integer> set, int idx, HashSet<Integer> visited) {
        int n = nums.length;

        if (idx == n) {
            res.add(new ArrayList<>(set));
            return;
        }

        for (int i = 0; i < n; i++) {
            if (i > 0 && nums[i] == nums[i - 1] && visited.contains(i - 1)) continue;
            if (visited.contains(i)) continue;
            set.add(nums[i]);
            visited.add(i);
            generatePermutations(nums, set, idx + 1, visited);
            set.remove(set.size() - 1);
            visited.remove(i);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> res = new _09_Permutations2().permuteUnique(nums);
        for (List<Integer> l : res) {
            for (int i : l) {
                System.out.print(i + ", ");
            }
            System.out.println("");
        }
    }
}
