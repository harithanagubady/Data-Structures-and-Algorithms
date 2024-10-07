/*

Wave traversal

https://geeksforgeeks.org/print-matrix-in-wave-form/

*   * * *   *
*   *   *   *
* * *   * * *

 */

import java.util.Scanner;

public class _03_WaveTraversal {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = scn.nextInt();
            }
        }
        for (int i = 0; i < m; i++) {
            if(i%2 == 0) {
                for (int j = 0; j < n; j++) {
                    System.out.println(arr[j][i]);
                }
            } else {
                for (int j = n-1; j >= 0; j--) {
                    System.out.println(arr[j][i]);
                }
            }
        }
    }

}