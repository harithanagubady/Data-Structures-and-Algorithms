import java.util.Scanner;

public class _07_TargetSumSubsets {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        int tar = scn.nextInt();
        System.out.println(targetSumSubsets(arr, tar));
    }

    private static boolean targetSumSubsets(int[] arr, int tar) {
        boolean[][] dp = new boolean[arr.length + 1][tar + 1];

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = true;
                } else if (i == 0) {
                    dp[i][j] = false;
                } else if (j == 0) {
                    dp[i][j] = true;
                } else {
                    dp[i][j] = dp[i - 1][j] ||
                            (j >= arr[i - 1] && dp[i - 1][j - arr[i - 1]]);
                }
            }
        }
        return dp[arr.length][tar];
    }
}
