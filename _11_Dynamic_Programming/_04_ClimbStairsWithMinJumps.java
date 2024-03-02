import java.util.Scanner;

public class _04_ClimbStairsWithMinJumps {

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        System.out.println(climbStairsWithMinJumps(arr, n));
    }

    public static Integer climbStairsWithMinJumps(int[] arr, int n) {

        Integer[] dp = new Integer[n + 1];
        dp[n] = 0;
        for (int i = n - 1; i >= 0; i--) {

            if(arr[i] == 0) continue;

            int min = Integer.MAX_VALUE;
            for (int j = 1; j <= arr[i] && i + j < dp.length; j++) {

                if (dp[i + j] == null) {
                    continue;
                }
                if (min > dp[i + j]) {
                    min = dp[i + j];
                }
            }
            dp[i] = min + 1;

        }
        return dp[0];
    }
}
