/*
https://leetcode.com/problems/merge-sorted-array/description/
 */
public class _23_LC88_MergeSortedArray {

    public static void main(String[] args) {
        int[] arr1 = new int[]{1, 2, 3, 0, 0, 0};
        int[] arr2 = new int[]{2, 5, 6};

        int m = 3, n = 3;

        mergeSortedArray(arr1, arr2, m, n);

        for (int i : arr1) {
            System.out.println(i);
        }
    }

    private static void mergeSortedArray(int[] arr1, int[] arr2, int m, int n) {
        int p1 = m - 1, p2 = n - 1;
        int i = m + n - 1;

        while (p2 >= 0) {
            if (p1 >= 0 && arr1[p1] > arr2[p2]) {
                arr1[i--] = arr1[p1--];
            } else {
                arr1[i--] = arr2[p2--];
            }
        }
    }
}
