/*
https://leetcode.com/problems/lucky-numbers-in-a-matrix/description/
 */

import java.util.Scanner;

public class _07_LC1380_SaddlePoint {

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


        approach1(arr);
    }

    private static void approach1(int[][] arr) {
        int colno = 0;
        for (int i = 0; i < arr.length; i++) {
            int min = arr[i][0];
            for (int j = 0; j < arr[i].length; j++) { // traversing in rows
                if (min > arr[i][j]) {
                    min = arr[i][j];
                    colno = j;
                }
            }
            boolean potentialSol = true;
            //check if the minimum value is maximum in that column
            for (int k = 0; k < arr.length; k++) { // traversing in columns
                if (min < arr[k][colno]) {
                    potentialSol = false;
                    break;
                }
            }

            if (potentialSol) {
                System.out.println(min);
                return;
            }
        }
    }
}

/*
3
3
3
7
8
9
11
13
15
16
17

3
4
1
10
4
2
9
3
8
7
15
16
17
12
 */