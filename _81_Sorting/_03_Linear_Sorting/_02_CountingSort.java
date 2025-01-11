package _03_Linear_Sorting;

public class _02_CountingSort {

    public void countingSort(int[] arr) {
        int max = findMax(arr);
        int[] count = new int[max + 1];
        for (int e : arr) {
            count[e]++;
        }
        sort(arr, max + 1, count);
    }

    public void sort(int[] arr, int len, int[] count) {
        for (int i = 1; i < len; i++) {
            count[i] += count[i - 1];
        }

        int n = arr.length;
        int[] output = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            output[count[arr[i]]-- - 1] = arr[i];
        }
        System.arraycopy(output, 0, arr, 0, n);
    }

    private static int findMax(int[] arr) {
        int max = 0;
        for (int i : arr) {
            max = Math.max(max, i);
        }
        return max;
    }
}
