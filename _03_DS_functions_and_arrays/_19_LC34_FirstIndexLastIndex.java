import java.util.*;

/*
https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/
 */
public class _19_LC34_FirstIndexLastIndex {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner (System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        int d = scn.nextInt();
        int low =0;
        int high = n-1;
        int first = bs(arr, d, low, high, true);
        int last = bs(arr, d, low, high, false);

        System.out.println(first);
        System.out.println(last);
    }

    private static int bs(int[] arr, int d, int low, int high, boolean isFirst) {
        int firstOrLast = -1;
        while(low <= high) {
            int mid = (low + high)/2;
            if(arr[mid] > d) {
                high = mid - 1;
            } else if (arr[mid] < d) {
                low = mid + 1;
            } else {
                firstOrLast = mid;
                if (isFirst)
                    high = mid - 1;
                else
                    low = mid + 1;
            }
        }
        return firstOrLast;
    }

}