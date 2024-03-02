import java.util.Scanner;

public class _08_CoinChangeCombinations {

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        int tar = scn.nextInt();

        System.out.println(countOfCoinCombinations(arr, tar));
    }

    public static int countOfCoinCombinations(int[] arr, int tar) {

        int[] dp = new int[tar + 1];
        dp[0] = 1;

        for (int k : arr) { //coins
            for (int i = k; i < dp.length; i++) {
                if (dp[i - k] != 0) {
                    dp[i] += dp[i - k];
                }
            }
        }
        return dp[tar];
    }
}
