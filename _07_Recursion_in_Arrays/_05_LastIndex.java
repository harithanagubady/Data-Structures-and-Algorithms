import java.io.*;
import java.util.*;


public class _05_LastIndex {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        int x = scn.nextInt();
//        System.out.println(lastIndex(arr, arr.length - 1, x));
//    }
//
//    public static int lastIndex(int[] arr, int idx, int x) {
//        if (idx <= -1) {
//            return -1;
//        }
//
//        if (x == arr[idx]) {
//            return idx;
//        }
//
//        return lastIndex(arr, idx - 1, x);
//    }
        System.out.println(lastIndex(arr, 0, x));
    }

    public static int lastIndex(int[] arr, int idx, int x) {
        if (idx == arr.length) {
            return -1;
        }

        int liisa = lastIndex(arr, idx + 1, x);
        if (liisa == -1) {
            if (arr[idx] == x) {
                return idx;
            } else {
                return -1;
            }
        } else {
            return liisa;
        }
    }
}