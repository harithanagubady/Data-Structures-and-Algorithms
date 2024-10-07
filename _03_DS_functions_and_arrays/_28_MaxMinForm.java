/*
https://www.geeksforgeeks.org/rearrange-array-maximum-minimum-form/
 */
public class _28_MaxMinForm {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};

        int[] res = maxMinForm1(arr);
        for (int i : res) {
            System.out.print(i + "\t");
        }
        System.out.println();
        maxMinForm2(arr);
        for (int i : arr) {
            System.out.print(i + "\t");
        }
    }

    private static int[] maxMinForm1(int[] arr) {

        int n = arr.length;
        int[] res = new int[n];

        int mid = n / 2;
        int idx = 0;
        for (int i = 0; i < mid; ++i) {
            res[idx++] = arr[n - i - 1];
            res[idx++] = arr[i];
        }

        if (n % 2 == 1) {
            res[idx] = arr[mid];
        }
        return res;
    }

    private static void maxMinForm2(int[] arr) {

        int n = arr.length;

        int minIdx = 0, maxIdx = n - 1;
        int maxElem = arr[maxIdx] + 1;
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                arr[i] += (arr[maxIdx--] % maxElem) * maxElem;
            } else {
                arr[i] += (arr[minIdx++] % maxElem) * maxElem;
            }
        }
        for (int i = 0; i < n; i++) {
            arr[i] /= maxElem;
        }
    }
}
