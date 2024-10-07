import java.io.*;
import java.util.*;

public class _13_ReverseanArray {
    public static void display(int[] a) {
        StringBuilder sb = new StringBuilder();

        for (int val : a) {
            sb.append(val).append(" ");
        }
        System.out.println(sb);
    }

    public static void reverse(int[] a) {
        int[] reverse = new int[a.length];
        for (int i = 0, j = a.length - 1; i < a.length && j >= 0; i++, j--) {
            reverse[j] = a[i];
        }
        for (int i = 0 ; i < reverse.length; i++) {
            a[i] = reverse[i];
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(br.readLine());
        }

        reverse(a);
        display(a);
    }

}