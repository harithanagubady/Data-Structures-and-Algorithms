import java.io.*;
        import java.util.*;

public class _09_SaddlePrice {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = scn.nextInt();
            }
        }


        int colno = 0;
        for (int i = 0; i < arr.length; i++) {
            int min = arr[i][0];
            for (int j = 0; j < arr[i].length; j++) {
                if (min > arr[i][j]) {
                    min = arr[i][j];
                    colno = j;
                }
            }
            boolean potentialSol = true;
            for (int k = 0; k < arr.length; k++) {
                if (min > arr[k][colno]) {
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