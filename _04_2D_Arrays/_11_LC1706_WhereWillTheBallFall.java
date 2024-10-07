import java.util.Arrays;

/*
https://leetcode.com/problems/where-will-the-ball-fall/description/
 */
public class _11_LC1706_WhereWillTheBallFall {

    public static void main(String[] args) {
        int[][] grid = {{1,1,1,-1,-1},{1,1,1,-1,-1},{-1,-1,-1,1,1},{1,1,1,1,-1},{-1,-1,-1,-1,-1}};

        int[] ans = findBallIterativeApproach(grid);
        System.out.println(Arrays.toString(ans));

        for (int col = 0; col < grid.length; col++) {
            System.out.print(dfs(grid, 0, col) + ", ");
        }
    }

    public static int[] findBallIterativeApproach(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;
        int[] ans = new int[n];
        for (int col = 0; col < n; col++) {
            int currCol = col;
            for (int row = 0; row < m; row++) {
                int nextCol = currCol + grid[row][currCol];
                if (nextCol < 0 || nextCol > n - 1 || grid[row][currCol] != grid[row][nextCol]) {
                    ans[col] = -1;
                    break;
                }
                if (row == m - 1) {
                    ans[col] = nextCol;
                }
                currCol = nextCol;
            }
        }
        return ans;
    }

    public static int dfs (int[][] grid, int i, int j) {
        if (i == grid.length) {
            return j;
        }

        if (j < 0 || j >= grid[0].length) {
            return -1;
        }

        if (grid[i][j] == 1 && j + 1 < grid[0].length && grid[i][j+1] == 1) {
            return dfs (grid, i + 1, j +1);
        } else if (grid[i][j] == -1 && j - 1 >= 0 && grid[i][j - 1] == -1) {
            return dfs (grid, i + 1, j -1);
        }

        return -1;
    }
}
