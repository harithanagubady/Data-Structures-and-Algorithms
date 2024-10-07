/*
https://leetcode.com/problems/remove-all-ones-with-row-and-column-flips/
 */

public class _10_LC2128_RemoveAllOnesWithFlips {

    public static void main(String[] args) {
        int[][] grid = {{1, 0, 1}, {0, 1, 0}, {1, 0, 1}};

        System.out.println(removeOnes(grid));

        int[][] grid1 = {{1, 0, 1}, {0, 1, 1}, {1, 0, 1}};

        System.out.println(removeOnes(grid1));
    }

    /*

    Intuition:
    pattern should be strictly:
    1) same or
    2) opposite

    1 0 0
    1 0 0
    1 0 0
    true

    0 1 0
    1 0 1
    0 1 0
    true

    1 1 1
    0 1 0
    0 0 0
    false
     */
    public static boolean removeOnes(int[][] grid) {
        for (int i = 1; i < grid.length; i++){
            for (int j = 1; j < grid[0].length; j++){
                if (Math.abs(grid[0][j] - grid[i][j]) != Math.abs(grid[0][0] - grid[i][0]))
                    return false;
            }
        }
        return true;
    }
}
