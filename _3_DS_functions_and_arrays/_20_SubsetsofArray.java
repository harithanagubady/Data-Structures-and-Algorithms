import java.io.*;
import java.util.*;

public class _20_SubsetsofArray {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        int limit = (int) Math.pow(2, n);
        for (int i = 0; i < limit; i++) {
            int temp = i;
            StringBuilder substr = new StringBuilder();
            for (int j = n - 1; j >= 0; j--) {
                if (temp % 2 == 1) {
                    substr.insert(0, arr[j] + "\t");
                } else {
                    substr.insert(0, "-" + "\t");
                }
                temp /= 2;
            }
            System.out.println(substr);
        }
    }

}