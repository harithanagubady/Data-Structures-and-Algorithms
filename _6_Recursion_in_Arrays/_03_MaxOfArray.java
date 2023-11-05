import java.io.*;
import java.util.*;


public class _03_MaxOfArray {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = scn.nextInt();
        }
        System.out.println(maxOfArray(arr, 0));
    }

    public static int maxOfArray(int[] arr, int idx){
        if(idx >= arr.length) {
            return Integer.MIN_VALUE;
        }
        int max = maxOfArray(arr, idx+1);
        if(arr[idx]>max){
            return arr[idx];
        } else {
            return max;
        }
    }

}