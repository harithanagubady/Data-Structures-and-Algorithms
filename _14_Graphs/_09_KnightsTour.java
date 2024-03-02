import java.util.Scanner;

public class _09_KnightsTour {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int row = scn.nextInt();
        int col = scn.nextInt();

        int[][] arr = new int[n][n];
        knightsTour(arr, row, col, 1 );
    }

    private static void knightsTour(int[][] arr, int row, int col, int val) {

        if (row < 0 || col < 0 || row >= arr.length || col >= arr.length || arr[row][col] != 0) {
            return;
        }

        if(val == arr.length * arr.length) {
            arr[row][col] = val;
            for (int[] i : arr) {
                for (int j : i) {
                    System.out.print(j + " ");
                }
                System.out.println();
            }
            System.out.println();
            arr[row][col] = 0;
        }

        arr[row][col] = val;
        knightsTour(arr, row - 2, col + 1, val + 1);
        knightsTour(arr, row - 1, col + 2, val + 1 );
        knightsTour(arr, row + 1, col + 2, val + 1 );
        knightsTour(arr, row + 2, col + 1, val + 1 );
        knightsTour(arr, row + 2, col - 1, val + 1 );
        knightsTour(arr, row + 1, col - 2, val + 1 );
        knightsTour(arr, row - 1, col - 2, val + 1 );
        knightsTour(arr, row - 2, col - 1, val + 1 );
        arr[row][col] = 0;
    }
}
