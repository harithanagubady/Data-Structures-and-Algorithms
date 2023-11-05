import java.io.*;
import java.util.*;

public class _10_SearchInA2DSortedArray {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = scn.nextInt();
            }
        }

        int num = scn.nextInt();

        int x = n * n;
        int i = 0, j = n - 1;
        boolean temp = false;
        while (x-- > 0) {
            if (num == arr[i][j]) {
                temp = true;
                break;
            } else if (num > arr[i][j]) {
                i = i + 1;
            } else {
                j = j - 1;
            }
        }

        if (temp) {
            System.out.println(i + " " + j);
        } else {
            System.out.println("Not Found");
        }
    }

}
