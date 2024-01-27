import java.util.Scanner;

public class _03_NQueens {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[][] arr = new int[n][n];

        printNQueens(arr, 0, "", 0);
    }

    private static void printNQueens(int[][] chess, int idx, String psf, int row) {

        if(idx == chess.length) {
            System.out.println(psf);
            return;
        }

        for (int col = 0; col < chess[0].length; col++) {
            if(isItASafePlaceForQueen(chess, row, col)) {
                chess[row][col] = 1;
                printNQueens(chess, idx + 1, psf + row + " - " + col + ", ", row + 1);
                chess[row][col] = 0;
            }
        }
    }

    private static boolean isItASafePlaceForQueen(int[][] chess, int row, int col) {

        for (int i = row - 1; i >= 0; i--) {
            if(chess[i][col] == 1) {
                return false;
            }
        }
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if(chess[i][j] == 1) {
                return false;
            }
        }
        for (int i = row - 1, j = col + 1; i >= 0 && j < chess.length; i--, j++) {
            if(chess[i][j] == 1) {
                return false;
            }
        }
        return true;
    }
}
