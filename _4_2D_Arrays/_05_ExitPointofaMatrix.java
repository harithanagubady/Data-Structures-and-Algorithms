import java.io.*;
import java.util.*;

public class _05_ExitPointofaMatrix {

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

        int i = 0, j = 0, dir = 0;
        while (true) {
            dir = (dir + arr[i][j]) % 4; // dir between 0 and 3
            if (dir == 0) {
                j++;
            } else if (dir == 1) {
                i++;
            } else if (dir == 2) {
                j--;
            } else if (dir == 3) {
                i--;
            }
            if (i < 0) {
                i++;
                break;
            } else if (j < 0) {
                j++;
                break;
            } else if (i == n) {
                i--;
                break;
            } else if (j == m) {
                j--;
                break;
            }
        }
        System.out.println(i);
        System.out.println(j);
    }
}
