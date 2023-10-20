import java.io.*;
import java.util.*;

public class _04_SpiralDisplay {

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
        int max = n*m;
        int count = 0;
        int min_row = 0;
        int min_col = 0;
        int max_row = n-1;
        int max_col = m-1;
        while (count < max) {

            //left wall
            for (int i = min_row; i <= max_row; i++) {
                System.out.println(arr[i][min_col]);
            }
            min_col++;

            //bottom wall
            for(int i = min_col; i <= max_col; i++){
                System.out.println(arr[max_row][i]);
            }
            max_row--;

            //right wall
            for(int i = max_row; i >= min_row; i--) {
                System.out.println(arr[i][max_col]);
            }
            max_col--;

            //top wall
            for(int i = max_col; i >= min_col; i--) {
                System.out.println(arr[min_row][i]);
            }
            min_row++;
            count++;
        }
    }

}