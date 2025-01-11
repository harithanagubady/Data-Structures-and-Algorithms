package _03_Linear_Sorting;

import _02_Advanced_Sorting._03_QuickSort;
import _02_Advanced_Sorting._04_HeapSort;

import java.util.Arrays;
import java.util.Random;

public class _01_LinearSort {

    static long start_time;
    static long end_time;

    public static void main(String[] args) {
        int[] arr = new int[1000];
        Random rd = new Random();

        for (int i = 0; i < 1000; i++) {
            arr[i] = rd.nextInt(1000);
        }

        int[] arr1 = Arrays.copyOf(arr, 1000);
        System.out.println("Counting Sort: ");

        start_time = System.currentTimeMillis();
        new _02_CountingSort().countingSort(arr1);
        end_time = System.currentTimeMillis();

        System.out.println(Arrays.toString(arr1));
        System.out.println("Processed Count Sort in " + (end_time - start_time) + "ms");
        System.out.println();

        int[] arr2 = Arrays.copyOf(arr, 1000);
        System.out.println("Radix Sort: ");
        //int[] ar = {12, 5, 13, 7, 8, 24};
        start_time = System.currentTimeMillis();
        new _03_RadixSort().radixSort(arr2);
        end_time = System.currentTimeMillis();

        System.out.println(Arrays.toString(arr2));
        System.out.println("Processed Radix Sort in " + (end_time - start_time) + "ms");
        System.out.println();

        int[] arr3 = Arrays.copyOf(arr, 1000);

        System.out.println("Bucket Sort: ");
        start_time = System.currentTimeMillis();
        new _04_BucketSort().bucketSort(arr3);
        end_time = System.currentTimeMillis();

        System.out.println(Arrays.toString(arr3));
        System.out.println("Processed Bucket Sort in " + (end_time - start_time) + "ms");
        System.out.println();
    }
}
