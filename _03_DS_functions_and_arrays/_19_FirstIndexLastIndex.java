import java.io.*;
import java.util.*;

public class _19_FirstIndexLastIndex {

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
        int first = -1;
        while(low <= high) {
            int mid = (low + high)/2;
            if(arr[mid] > d) {
                high = mid - 1;
            } else if (arr[mid] < d) {
                low = mid + 1;
            } else {
                first = mid;
                high = mid - 1;
            }
        }
        low =0;
        high = n-1;
        int last = -1;
        while(low <= high) {
            int mid = (low + high)/2;
            if(arr[mid] > d) {
                high = mid - 1;
            } else if (arr[mid] < d) {
                low = mid + 1;
            } else {
                last = mid;
                low = mid + 1;
            }
        }
        System.out.println(first);
        System.out.println(last);
    }

}