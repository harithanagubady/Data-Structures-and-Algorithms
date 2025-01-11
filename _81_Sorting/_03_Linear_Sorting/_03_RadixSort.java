package _03_Linear_Sorting;

import java.util.Arrays;

public class _03_RadixSort {

    public void radixSort(int[] arr) {
        int max = findMax(arr);
        int n = arr.length;

        for (int b = 1; max/b > 0; b *= 10) {
            int[] count = new int[10];
            for (int j : arr) {
                count[(j / b) % 10]++;
            }

            for (int i = 1; i < 10; i++) {
                count[i] += count[i - 1];
            }

            int[] output = new int[n];
            for (int i = n - 1; i >= 0; i--) {
                output[count[(arr[i]/b) % 10]-- - 1] = arr[i];
            }

            System.arraycopy(output, 0, arr, 0, n);
        }
    }
    private int findMax(int[] arr) {
        int max = 0;
        for (int i : arr) {
            max = Math.max(max, i);
        }
        return max;
    }
}
