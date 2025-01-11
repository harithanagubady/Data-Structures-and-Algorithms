package _03_Linear_Sorting;

import java.util.ArrayList;
import java.util.Collections;

public class _04_BucketSort {

    public void bucketSort (int[] arr) {
        int max = findMax(arr);
        int n = arr.length;

        int noOfBuckets = (int)Math.sqrt(n);
        ArrayList<Integer>[] buckets = new ArrayList[noOfBuckets];

        for (int i = 0; i < noOfBuckets; i++) {
            buckets[i] = new ArrayList<>();
        }

        for (int i : arr) {
            buckets[(i * noOfBuckets) / (max + 1)].add(i);
        }

        int idx = 0;
        for (ArrayList<Integer> bucket : buckets) {
            Collections.sort(bucket);
            for (int e : bucket) arr[idx++] = e;
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
