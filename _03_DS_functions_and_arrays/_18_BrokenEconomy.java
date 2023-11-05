import java.io.*;
import java.util.*;

public class _18_BrokenEconomy{

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner (System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        double d = scn.nextDouble();
        int floor = -1;
        int ceil = -1;
        for (int i = 0; i < n; i++) {
            if(d==arr[i]) {
                floor = arr[i];
                ceil = arr[i];
                break;
            }
            if(arr[i] < d) {
                floor = arr[i];
            }
            if(arr[i] > d) {
                ceil = arr[i];
                break;
            }

        }
        System.out.println(ceil);
        System.out.println(floor);
    }

}