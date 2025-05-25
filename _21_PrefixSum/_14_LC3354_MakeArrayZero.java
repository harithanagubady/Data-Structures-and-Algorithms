public class _14_LC3354_MakeArrayZero {


    public static void main(String[] args) {
        int[] arr = {1, 0, 2, 0, 3};
        System.out.println(countValidSelections(arr));

        int[] arr1 = {1, 0, 3, 0, 3};
        System.out.println(countValidSelections(arr1));

        int[] arr2 = {1, 1, 3, 0, 3};
        System.out.println(countValidSelections(arr2));

        int[] arr3 = {1, 1, 0, 1, 2};
        System.out.println(countValidSelections(arr3));
    }

    public static int countValidSelections(int[] nums) {
        int n = nums.length;

        int[] left = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            left[i] = left[i - 1] + nums[i - 1];
        }

        int res = 0;

        for (int i = 0; i < n; i++) {
            if (nums[i] != 0) continue;
            if (left[i] == left[n] - left[i + 1]) res += 2;
            if (Math.abs(left[i] - left[n] + left[i + 1]) == 1) res += 1;
        }

        return res;
    }
}
