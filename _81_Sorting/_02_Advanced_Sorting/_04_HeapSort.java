package _02_Advanced_Sorting;

import java.util.Arrays;

public class _04_HeapSort {

    public void heapSort1(int[] arr) {

        bubbleUpHeapify(arr, arr.length - 1);
        for (int i = arr.length - 1; i >= 0; i--) {
            removeFromMaxHeap(arr, i);
            bubbleDownHeapifyIteration(arr, 0, i - 1);
        }
    }

    public void heapSort2(int[] arr) {
        int n = arr.length;
        for (int i = n/2 - 1; i >= 0; i--) {
            bubbleDownHeapifyIteration(arr, i, n - 1);
        }

        for (int i = n - 1; i >= 0; i--) {
            removeFromMaxHeap(arr, i);
            bubbleDownHeapifyIteration(arr, 0, i - 1);
        }
    }

    private void removeFromMaxHeap(int[] arr, int lastIdx) {
        //remove
        int rem = arr[0];
        arr[0] = arr[lastIdx];
        arr[lastIdx] = rem;
    }

    //Iteration
    private void bubbleUpHeapify(int[] arr, int end) {

        for (int i = 1; i <= end; i++) {
            int childIdx = i;
            int parentIdx = (i - 1) / 2;
            while (parentIdx >= 0 && arr[childIdx] > arr[parentIdx]) {
                //swap
                int tmp = arr[childIdx];
                arr[childIdx] = arr[parentIdx];
                arr[parentIdx] = tmp;
                childIdx = parentIdx;
                parentIdx = (parentIdx - 1) / 2;
            }
        }
    }

    //Recursion
    private void bubbleDownHeapifyRecursion(int[] arr, int i, int end) {
        int l = 2 * i + 1, r = 2 * i + 2;

        int largest = i;
        if (l <= end && arr[l] > arr[largest]) {
            largest = l;
        }
        if (r <= end && arr[r] > arr[largest]) {
            largest = r;
        }

        if (largest != i) {
            int tmp = arr[largest];
            arr[largest] = arr[i];
            arr[i] = tmp;
            bubbleDownHeapifyRecursion(arr, largest, end);
        }
    }

    private void bubbleDownHeapifyIteration(int[] arr, int i, int end) {

        int largest = i;

        while (true) {
            int l = 2 * i + 1, r = 2 * i + 2;
            if (l <= end && arr[l] > arr[largest]) {
                largest = l;
            }
            if (r <= end && arr[r] > arr[largest]) {
                largest = r;
            }
            if (largest == i) break;
            int tmp = arr[largest];
            arr[largest] = arr[i];
            arr[i] = tmp;
            i = largest;
        }
    }
}
