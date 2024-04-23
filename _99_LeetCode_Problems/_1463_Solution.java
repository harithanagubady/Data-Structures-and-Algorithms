public class _1463_Solution {

    public int cherryPickup(int[][] grid) {

        int noOfRows = grid.length;
        int noOfColumns = grid[0].length;
        Integer[][][] dp = new Integer[noOfRows + 1][noOfColumns + 1][noOfColumns + 1];

        return helper(grid, 0, 0, noOfColumns - 1, dp);
    }

    public int helper (int[][] grid, int currRow, int robotACol, int robotBCol, Integer[][][] dp) {

        if (robotACol < 0 || robotBCol < 0 || robotACol >= grid[0].length
                || robotBCol >= grid[0].length) {
            return 0;
        }

        if (currRow == grid.length) {
            return 0;
        }

        if (dp[currRow][robotACol][robotBCol] != null) {
            return dp[currRow][robotACol][robotBCol];
        }
        int result = 0;
        result += grid[currRow][robotACol];
        result += grid[currRow][robotBCol];

        int max = 0;
        for (int x = robotACol - 1; x <= robotACol + 1; x++) {
            for (int y = robotBCol - 1; y <= robotBCol + 1; y++) {
                if (x < y) {
                    max = Math.max(max, helper(grid, currRow + 1, x, y, dp));
                }
            }
        }

        result += max;
        return dp[currRow][robotACol][robotBCol] = result;
    }

    public static void main(String[] args) {
        int[][] grid = {{3, 1, 1},
                        {2, 5, 1},
                        {1, 5, 5},
                        {2, 1, 1}};
        System.out.println(new _1463_Solution().cherryPickup(grid));
    }
}
