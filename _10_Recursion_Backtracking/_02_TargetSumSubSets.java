import java.util.Scanner;

public class _02_TargetSumSubSets {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        int tar = scn.nextInt();
        printTargetSumSubsets(arr, 0, tar, "", 0);
    }

    public static void printTargetSumSubsets(int[] arr, int idx, int tar, String set, int sos) {

        if (sos == tar) {
            System.out.println(set + "\b\b");
            return;
        }

        if (idx == arr.length) {
            return;
        }

        printTargetSumSubsets(arr, idx + 1, tar, set, sos);
        printTargetSumSubsets(arr, idx + 1, tar, set + arr[idx] + ", ", sos + arr[idx]);
    }
}
