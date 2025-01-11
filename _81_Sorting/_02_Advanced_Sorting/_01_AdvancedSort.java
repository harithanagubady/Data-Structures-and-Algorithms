package _02_Advanced_Sorting;

import java.util.Arrays;
import java.util.Random;

public class _01_AdvancedSort {

    static long start_time;
    static long end_time;

    public static void main(String[] args) {
        int[] arr = new int[1000];
        Random rd = new Random();

        for (int i = 0; i < 1000; i++) {
            arr[i] = rd.nextInt(1000);
        }

        int[] arr1 = Arrays.copyOf(arr, 1000);
        System.out.println("Merge Sort: ");

        start_time = System.currentTimeMillis();
        new _02_MergeSort().mergeSort(arr1);
        end_time = System.currentTimeMillis();

        System.out.println(Arrays.toString(arr1));
        System.out.println("Processed Merge Sort in " + (end_time - start_time) + "ms");
        System.out.println();

        int[] arr2 = Arrays.copyOf(arr, 1000);
        //int[] ar = {5, 12, 13, 7, 8, 24};
        System.out.println("Quick Sort: ");

        start_time = System.currentTimeMillis();
        new _03_QuickSort().quickSort(arr2);
        end_time = System.currentTimeMillis();

        System.out.println(Arrays.toString(arr2));
        System.out.println("Processed Quick Sort in " + (end_time - start_time) + "ms");
        System.out.println();

        int[] arr3 = Arrays.copyOf(arr, 1000);
        //int[] ar = {12, 5, 13, 7, 8, 24};
        System.out.println("Heap Sort 1: ");
        start_time = System.currentTimeMillis();
        new _04_HeapSort().heapSort1(arr3);
        end_time = System.currentTimeMillis();

        System.out.println(Arrays.toString(arr3));
        System.out.println("Processed Heap Sort 1 in " + (end_time - start_time) + "ms");
        System.out.println();

        int[] arr4 = Arrays.copyOf(arr, 1000);
        int[] ar1 = {12, 5, 13, 7, 8, 24};
        System.out.println("Heap Sort 2: ");
        start_time = System.currentTimeMillis();
        new _04_HeapSort().heapSort2(arr4);
        end_time = System.currentTimeMillis();

        System.out.println(Arrays.toString(arr4));
        System.out.println("Processed Heap Sort 2 in " + (end_time - start_time) + "ms");
        System.out.println();
    }
}
