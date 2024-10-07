/*

Print upper diagonal in downward direction
Input is a square matrix
eg:
1 2 3
4 5 6
7 8 9

o/p: 1, 5, 9, 2, 6, 3

 */

import java.util.Scanner;

public class _06_UpperDiagonal {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[][] arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = scn.nextInt();
            }
        }


        for (int gap = 0; gap < n; gap++) {
            for (int i = 0, j = gap; j < n; i++, j++) {
                System.out.println(arr[i][j]);
            }
        }

    }
}