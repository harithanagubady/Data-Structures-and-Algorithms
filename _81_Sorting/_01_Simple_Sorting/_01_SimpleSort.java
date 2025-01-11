package _01_Simple_Sorting;

import java.util.Arrays;
import java.util.Random;

public class _01_SimpleSort {

    static long start_time;
    static long end_time;

    public static void main(String[] args) {
        int[] arr = new int[1000];
        Random rd = new Random();

        for (int i = 0; i < 1000; i++) {
            arr[i] = rd.nextInt(1000);
        }

        int[] arr1 = Arrays.copyOf(arr, 1000);
        System.out.println("Bubble Sort: ");

        start_time = System.currentTimeMillis();
        new _02_BubbleSort().bubbleSort(arr1);
        end_time = System.currentTimeMillis();

        System.out.println(Arrays.toString(arr1));
        System.out.println("Processed Bubble Sort in " + (end_time - start_time) + "ms");
        System.out.println();

        int[] arr2 = Arrays.copyOf(arr, 1000);
        System.out.println("Selection Sort: ");

        start_time = System.currentTimeMillis();
        new _03_SelectionSort().selectionSort(arr2);
        end_time = System.currentTimeMillis();

        System.out.println(Arrays.toString(arr2));
        System.out.println("Processed Selection Sort in " + (end_time - start_time) + "ms");
        System.out.println();

        int[] arr3 = Arrays.copyOf(arr, 1000);
        System.out.println("Insertion Sort: ");

        start_time = System.currentTimeMillis();
        new _04_InsertionSort().insertionSort(arr3);
        end_time = System.currentTimeMillis();

        System.out.println(Arrays.toString(arr3));
        System.out.println("Processed Insertion Sort in " + (end_time - start_time) + "ms");
        System.out.println();
    }
}
