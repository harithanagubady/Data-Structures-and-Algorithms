/*
https://leetcode.com/problems/diagonal-traverse/description/
 */
public class _09_LC498_DiagonalTraverse {
    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};
        int[] ans = findDiagonalOrder(arr);
        for (int i : ans) {
            System.out.print(i + "\t");
        }
        System.out.println();
        int[] ans1 = findDiagonalOrder2(arr);
        for (int i : ans1) {
            System.out.print(i + "\t");
        }
    }

    public static int[] findDiagonalOrder2(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return new int[0];
        int m = matrix.length, n = matrix[0].length;

        int[] result = new int[m * n];
        int row = 0, col = 0, d = 1;

        for (int i = 0; i < m * n; i++) {
            result[i] = matrix[row][col];
            if ((row + col) % 2 == 0) {
                if (row - 1 >= 0 && col + 1 <= n - 1) {
                    col += 1;
                    row -= 1;
                } else if (row - 1 < 0 && col + 1 <= n - 1) {
                    col += 1;
                } else if (row + 1 < m && col + 1 > n - 1) {
                    row += 1;
                }
            } else if ((row + col) % 2 != 0) {
                if (row + 1 <= m - 1 && col - 1 >= 0) {
                    row += 1;
                    col -= 1;
                } else if (row + 1 <= m - 1 && col - 1 < 0) {
                    row += 1;
                } else if (row + 1 > m - 1 && col + 1 <= n - 1) {
                    col += 1;
                }
            }
        }

        return result;
    }

    public static int[] findDiagonalOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return new int[0];
        int m = matrix.length, n = matrix[0].length;

        int[] result = new int[m * n];
        int row = 0, col = 0, d = 1;

        for (int i = 0; i < m * n; i++) {
            result[i] = matrix[row][col];
            row -= d;
            col += d;
            //bottom border
            if (row > m - 1) {
                row = m - 1;
                col += 2;
                d = -d;
            }

            //left border
            if (col < 0) {
                col = 0;
                d = -d;
            }

            //right border
            if (col > n - 1) {
                col = n - 1;
                row += 2;
                d = -d;
            }

            //top border
            if (row < 0) {
                row = 0;
                d = -d;
            }
        }

        return result;
    }
}
