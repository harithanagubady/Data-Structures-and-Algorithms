import java.io.*;
import java.util.*;

public class _15_InverseofArray {
    public static void display(int[] a){
        StringBuilder sb = new StringBuilder();

        for(int val: a){
            sb.append(val).append("\n");
        }
        System.out.println(sb);
    }

    public static int[] inverse(int[] a){
        int len = a.length;
        int[] inv = new int[len];
        for (int i = 0; i < len; i++) {
            int val = a[i];
            inv[val] = i;
        }
        return inv;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        for(int i = 0; i < n; i++){
            a[i] = Integer.parseInt(br.readLine());
        }

        int[] inv = inverse(a);
        display(inv);
    }

}