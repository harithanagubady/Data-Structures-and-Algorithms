import java.util.*;

/*
https://www.geeksforgeeks.org/add-two-numbers-represented-by-two-arrays/
 */
public class _11_SumofArrays {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n1 = scn.nextInt();
        int[] A = new int[n1];
        for (int i = 0; i < n1; i++) {
            A[i] = scn.nextInt();
        }

        int n2 = scn.nextInt();
        int[] B = new int[n1];
        for (int j = 0; j < n2; j++) {
            B[j] = scn.nextInt();
        }
        int i = n1 - 1;
        int j = n2 - 1;
        int c = 0;
        int[] sum = new int[Math.max(n1, n2)];
        int k = sum.length - 1;
        while (i >= 0 || j >= 0) {
            int d = c;
            if (i >= 0) {
                d += A[i];
            }
            if (j >= 0) {
                d += B[j];
            }
            c = d / 10;
            sum[k] = d % 10;
            i--;
            j--;
            k--;
        }
        if (c > 0) {
            System.out.println(c);
        }
        for (int val : sum) {
            System.out.println(val);
        }
    }

}