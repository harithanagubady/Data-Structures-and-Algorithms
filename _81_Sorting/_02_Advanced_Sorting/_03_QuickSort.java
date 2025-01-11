package _02_Advanced_Sorting;

public class _03_QuickSort {

    public void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(int[] arr, int low, int high) {
        if (low >= high) return;
        int pivotIdx = partition2(arr, low, high);
        quickSort(arr, low, pivotIdx - 1);
        quickSort(arr, pivotIdx + 1, high);
    }

    //pointers (i, j) where j moving from low to high
    private static int partition(int[] arr, int low, int high) {

        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
            }
        }
        int tmp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = tmp;

        return i + 1;
    }

    //pointers (i, j) where i moving towards right and j moving towards left
    private static int partition2(int[] arr, int low, int high) {

        int i = low, j = high - 1;
        while (true) {
            while (i <= high - 1 && arr[i] <= arr[high]) {
                i++;
            }
            while (j >= low && arr[j] > arr[high]) {
                j--;
            }
            if (i > j) break;

            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }
        int tmp = arr[i];
        arr[i] = arr[high];
        arr[high] = tmp;
        return i;
    }
}
