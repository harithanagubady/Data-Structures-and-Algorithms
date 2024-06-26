import java.util.Scanner;

public class _10_01KnapsackProblem {

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();

        int[] values = new int[n+1];
        int[] weights = new int[n+1];
        for (int i = 1; i <= n; i++) {
            values[i] = scn.nextInt();
        }
        for (int i = 1; i <= n; i++) {
            weights[i] = scn.nextInt();
        }

        int cap = scn.nextInt();

        int[][] dp = new int[n + 1][cap + 1];
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                dp[i][j] = dp[i - 1][j]; // if he doesn't bat
                if (j >= weights[i]) {
                    int remCap = j - weights[i];
                    if (dp[i - 1][remCap] + values[i] > dp[i][j]) { // if he does bat
                        dp[i][j] = dp[i - 1][remCap] + values[i];
                    }
                }
            }
        }

        System.out.println(dp[n][cap]);
    }
}
