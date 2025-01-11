package _01_Simple_Sorting;

public class _02_BubbleSort {

    public void bubbleSort(int[] arr) {
        helper(arr, arr.length - 1);
    }

    private void helper(int[] arr, int n) {
        if (n == 0) return;
        boolean isSwapped = false;
        for (int i = 0; i < n; i++) {
            if (arr[i] > arr[i + 1]) {
                int tmp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = tmp;
                isSwapped = true;
            }
        }

        if (!isSwapped) return;
        helper(arr, n - 1);
    }
}
