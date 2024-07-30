import java.util.Arrays;

/*
n - rows
m - columns
n*m numbers represent elements in 2d maze
You are standing in top-left cell and are required to move to bottom-right cell
1 cell right or 1 cell down movement is allowed in 1 motion
Each cell has a value that will have to be paid to enter that cell (even for top-left and bottom-right cell)
Print min cost
 */
public class _05_MinCostInMaze {

    public static void main(String[] args) {
//        Scanner scn = new Scanner(System.in);
//        int n = scn.nextInt();
//        int m = scn.nextInt();

//        int[][] cost = new int[n][m];
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < m; j++) {
//                cost[i][j] = scn.nextInt();
//            }
//        }
        int[][] cost = {{2, 8, 4, 1, 6, 4, 2},
                {6, 0, 9, 5, 3, 8, 5},
                {1, 4, 3, 4, 0, 6, 5},
                {6, 4, 7, 2, 4, 6, 1},
                {1, 0, 3, 7, 1, 2, 7},
                {1, 5, 3, 2, 3, 0, 9},
                {2, 2, 5, 1, 9, 8, 2}};
        System.out.println(minCostInMaze(cost));//expected: 36
        int[][] cost1 = {{2, 8, 4, 1, 6, 4, 2},
                {6, 0, 9, 5, 3, 8, 5},
                {1, 4, 3, 4, 0, 6, 5},
                {6, 4, 7, 2, 4, 6, 1},
                {1, 0, 3, 7, 1, 2, 7},
                {1, 5, 3, 2, 3, 0, 9},
                {2, 2, 5, 1, 9, 8, 2}};
        System.out.println(minCostInMaze1(cost1));
    }

    public static int minCostInMaze(int[][] cost) {

        //filling bottom-right to top-left
        for (int i = cost.length - 1; i >= 0; i--) {
            for (int j = cost[0].length - 1; j >= 0; j--) {
                if (i == cost.length - 1 && j == cost[0].length - 1) {
                    cost[i][j] = cost[i][j];
                } else if (i == cost.length - 1) { //can also write separate for loop to fill last row
                    cost[i][j] = cost[i][j + 1] + cost[i][j];
                } else if (j == cost[0].length - 1) { //can also write separate for loop to fill last column
                    cost[i][j] = cost[i + 1][j] + cost[i][j];
                } else {
                    cost[i][j] = Math.min(cost[i + 1][j], cost[i][j + 1]) + cost[i][j];
                }
            }
        }
        return cost[0][0];
    }

    //more optimal approach
    public static int minCostInMaze1(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        //filling first column - as you can come to current cell only from top in the row
        for (int i = 1; i < m; i++) {
            grid[i][0] += grid[i - 1][0];
        }

        //filling first row - as you can come to current cell only from left in the row
        for (int j = 1; j < n; j++) {
            grid[0][j] += grid[0][j - 1];
        }

        //filling cells from (1,1) - you can come from either top or left, so choose minimum
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
            }
        }

        return grid[m - 1][n - 1];
    }

}
