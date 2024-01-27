import java.util.Scanner;

public class _04_KnightsTour {

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int row = scn.nextInt();
        int col = scn.nextInt();
        int[][] chess = new int[n][n];
        printKnightsTour(chess, row, col, 1);
    }

    public static void printKnightsTour(int[][] chess, int row, int col, int move) {

        if(row < 0 || col < 0 || row >= chess.length || col >= chess[0].length || chess[row][col] > 0) {
            return;
        }

        if (move == chess.length * chess.length) {
            chess[row][col] = move; // last move also to be counted
            displayBoard(chess);
            chess[row][col] = 0;  // last move should be set to zero otherwise, following recursions provide incorrect results
            return;
        }

        chess[row][col] = move;
        printKnightsTour(chess, row - 2, col + 1, move + 1);
        printKnightsTour(chess, row - 1, col + 2, move + 1);
        printKnightsTour(chess, row + 1, col + 2, move + 1);
        printKnightsTour(chess, row + 2, col + 1, move + 1);
        printKnightsTour(chess, row + 2, col - 1, move + 1);
        printKnightsTour(chess, row + 1, col - 2, move + 1);
        printKnightsTour(chess, row - 1, col - 2, move + 1);
        printKnightsTour(chess, row - 2, col - 1, move + 1);
        chess[row][col] = 0;
    }

    public static void displayBoard(int[][] chess) {

        for (int[] ints : chess) {
            for (int i : ints) {
                System.out.print(i + "\t");
            }
            System.out.println();
        }
        System.out.println();
    }
}
