import java.util.Scanner;

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
    }

    public static int minCostInMaze(int[][] cost) {

        //int[][] dp = new int[n][m];

        for (int i = cost.length - 1; i >= 0; i--) {
            for (int j = cost[0].length - 1; j >= 0; j--) {
                if (i == cost.length - 1 && j == cost[0].length - 1) {
                    cost[i][j] = cost[i][j];
                } else if (i == cost.length - 1) {
                    cost[i][j] = cost[i][j + 1] + cost[i][j];
                } else if (j == cost[0].length - 1) {
                    cost[i][j] = cost[i + 1][j] + cost[i][j];
                } else {
                    cost[i][j] = Math.min(cost[i + 1][j], cost[i][j + 1]) + cost[i][j];
                }
            }
        }
        return cost[0][0];
    }
}
