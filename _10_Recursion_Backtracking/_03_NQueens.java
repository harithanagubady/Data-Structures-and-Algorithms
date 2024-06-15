import java.util.*;

public class _03_NQueens {

    static ArrayList<String> l = new ArrayList<>();
    static Set<Integer> ld = new HashSet<>();
    static Set<Integer> rd = new HashSet<>();
    static Set<Integer> cl = new HashSet<>();

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[][] arr = new int[n][n];

        printNQueens(arr, 0, "", 0);

        printNQueensOptimised(0, n);
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

    private static void printNQueensOptimised(int row, int n) {

        if(row == n) {
            System.out.println(l);
            return;
        }

        for (int col = 0; col < n; col++) {
            StringBuilder str = new StringBuilder();
            if(isItASafePlaceForQueen1(row, col)) {
                ld.add(row - col);
                rd.add(row + col);
                cl.add(col);
                str.append(row).append("-").append(col);
                l.add(str.toString());
                printNQueensOptimised(row + 1, n);
                ld.remove(row - col);
                rd.remove(row + col);
                cl.remove(col);
                l.remove(str.toString());
            }
        }
    }

    private static boolean isItASafePlaceForQueen1(int row, int col) {

        return !ld.contains(row - col) && !rd.contains(row + col) && !cl.contains(col);
    }
}
