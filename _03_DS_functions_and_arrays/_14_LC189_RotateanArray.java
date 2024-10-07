/*
https://leetcode.com/problems/rotate-array/description/
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class _14_LC189_RotateanArray {
    public static void display(int[] a) {
        StringBuilder sb = new StringBuilder();

        for (int val : a) {
            sb.append(val).append(" ");
        }
        System.out.println(sb);
    }

    private static int[] rotate(int[] a, int k) {

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
        return result;
    }

    private static int[] rotate2(int[] a, int k) {

        int n = a.length;
        int[] result = new int[n];

        if (k < 0) {
            k = n + k;
        }
        k = k % n;
        for (int i = 0; i < k; i++) {
            result[i] = a[n - k + i];
        }

        for (int i = k; i < n; i++) {
            result[i] = a[i - k];
        }
        return result;
    }

    //Slice Shift rotation
    private static int[] rotate3(int[] a, int k) {

        int n = a.length;
        int[] result = new int[n];

        if (k < 0) {
            k = n + k;
        }
        k = k % n;

        System.arraycopy(a, n - k, result, 0, k);
        System.arraycopy(a, 0, result, k, n - k);

        return result;
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
        int[] ans = rotate(a, k);
        display(ans);

        int[] ans1 = rotate2(a, k);
        display(ans1);

        int[] ans2 = rotate3(a, k);
        display(ans2);
    }
}