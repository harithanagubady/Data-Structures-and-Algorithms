import java.util.Scanner;

public class _06_RotateBy90deg {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();

        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = scn.nextInt();
            }
        }

//        System.out.println("Input matrix: ");
//        printArray(arr);

        int[][] newarr = new int[m][n];

        //Transpose the matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                newarr[j][i] = arr[i][j];
            }
        }

//        System.out.println("Transposed matrix: ");
//        printArray(newarr);

        //Reverse each array
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n/2; j++) {
                int temp = newarr[i][j];
                newarr[i][j] = newarr[i][n-j-1];
                newarr[i][n-j-1] = temp;
            }
        }

        //System.out.println("Rotated matrix: ");
        printArray(newarr);
    }

    static void printArray(int[][] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                System.out.print(a[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
