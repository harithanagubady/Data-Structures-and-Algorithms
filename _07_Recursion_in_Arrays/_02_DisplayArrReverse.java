import java.io.*;
import java.util.*;

public class _02_DisplayArrReverse {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = scn.nextInt();
        }
        displayArrReverse(arr, arr.length-1);
    }

    public static void displayArrReverse(int[] arr, int idx) {
        if(idx==-1) return;
        System.out.println(arr[idx]);
        displayArrReverse(arr, idx-1);
    }

}