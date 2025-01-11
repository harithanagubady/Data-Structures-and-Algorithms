package _01_Simple_Sorting;

public class _03_SelectionSort {

    public void selectionSort (int[] arr) {
        int sortedIdx = -1;
        int n = arr.length;
        while (sortedIdx < n - 1) {
            int idx = sortedIdx + 1;
            for (int i = idx + 1; i < n - 1; i++) {
                if (arr[idx] > arr[i]) {
                    idx = i;
                }
            }
            int tmp = arr[idx];
            arr[idx] = arr[++sortedIdx];
            arr[sortedIdx] = tmp;
        }
    }
}
