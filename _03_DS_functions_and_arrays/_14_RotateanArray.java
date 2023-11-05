import java.io.*;
import java.util.*;

public class _14_RotateanArray {
    public static void display(int[] a) {
        StringBuilder sb = new StringBuilder();

        for (int val : a) {
            sb.append(val + " ");
        }
        System.out.println(sb);
    }

    public static void reverse(int[] a) {
        int n = a.length;
        int i = 0;
        int j = n - 1;
        while (i < j) {
            int temp = a[i];
            a[i] = a[j];
            a[j] = temp;
            i++;
            j--;
        }
    }

    private static void rotate(int[] a, int k) {

        int n = a.length;
        int[] result = new int[n];
        k = k % n;
        for (int i = 0; i < n; i++) {
            if (k < 0) {
                result[(i + k + n) % n] = a[i];
            } else {
                result[(i + k) % n] = a[i];
            }
        }

        for (int i = 0; i < n; i++) {
            a[i] = result[i];
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(br.readLine());
        }
        int k = Integer.parseInt(br.readLine());
        //reverse(a);
        rotate(a, k);
        display(a);
    }
}