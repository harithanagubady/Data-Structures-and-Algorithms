import java.io.*;
import java.util.*;

public class _18_BrokenEconomy2{

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner (System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        double d = scn.nextDouble();
        int low = 0, high = n-1;
        int ceil = Integer.MAX_VALUE;
        int floor = Integer.MIN_VALUE;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (d < arr[mid]) {
                high = mid - 1;
                ceil = arr[mid];
            } else if (d > arr[mid]) {
                low = mid + 1;
                floor = arr[mid];
            } else {
                ceil = floor = arr[mid];
                break;
            }
        }
        System.out.println(ceil);
        System.out.println(floor);
    }

}