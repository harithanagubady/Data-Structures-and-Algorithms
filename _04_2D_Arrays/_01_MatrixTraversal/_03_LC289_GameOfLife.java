package _01_MatrixTraversal;/*
https://leetcode.com/problems/game-of-life/description/
 */

import java.util.Arrays;

public class _03_LC289_GameOfLife {

    public static void main(String[] args) {
        int[][] matrix1 = {{0, 1, 0},
                {0, 0, 1},
                {1, 1, 1},
                {0, 0, 0}};
        gameOfLife1(matrix1);
        for (int[] i : matrix1) {
            System.out.println(Arrays.toString(i));
        }

        System.out.println("=========");
        int[][] matrix2 = {{0, 1, 0},
                {0, 0, 1},
                {1, 1, 1},
                {0, 0, 0}};
        gameOfLife2(matrix2);
        for (int[] i : matrix2) {
            System.out.println(Arrays.toString(i));
        }
    }

    public static void gameOfLife1(int[][] board) {

        int m = board.length, n = board[0].length;

        int[][] temp = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int neighbors = calculateNeighbors1(board, i, j);
                if (board[i][j] == 1) {
                    temp[i][j] = (neighbors < 2 || neighbors > 3) ? 0 : 1;

                } else {
                    temp[i][j] = neighbors == 3 ? 1 : 0;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = temp[i][j];
            }
        }
    }

    public static void gameOfLife2(int[][] board) {

        int m = board.length, n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int neighbors = calculateNeighbors2(board, i, j);
                if (board[i][j] == 1 && neighbors >= 2 && neighbors <= 3) {
                    board[i][j] = 3;// 01 --> 11
                } else if (board[i][j] == 0 && neighbors == 3) {
                    board[i][j] = 2; // 00 ---> 10
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] >>= 1; // update board with new state
            }
        }
    }


    public static int calculateNeighbors1(int[][] board, int row, int col) {
        int sum = 0;
        for (int i = Math.max(row - 1, 0); i <= Math.min(row + 1, board.length - 1); i++) {
            for (int j = Math.max(col - 1, 0); j <= Math.min(col + 1, board[0].length - 1); j++) {
                sum += board[i][j];

            }
        }
        sum -= board[row][col];
        return sum;
    }

    public static int calculateNeighbors2(int[][] board, int row, int col) {
        int neighbors = 0;
        for (int i = Math.max(row - 1, 0); i <= Math.min(row + 1, board.length - 1); i++) {
            for (int j = Math.max(col - 1, 0); j <= Math.min(col + 1, board[0].length - 1);
                 j++) {
                neighbors += board[i][j] & 1;
            }
        }
        neighbors -= board[row][col] & 1;
        return neighbors;
    }
}
