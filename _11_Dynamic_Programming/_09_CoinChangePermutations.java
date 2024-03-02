import java.util.Scanner;

public class _09_CoinChangePermutations {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        int tar = scn.nextInt();

        System.out.println(coinChangePermutations(arr, tar));
    }

    private static int coinChangePermutations(int[] arr, int tar) {

        int[] dp = new int[tar + 1];
        dp[0] = 1;

        for (int i = 1; i <= tar; i++) {
            for (int k : arr) {
                if (i - k >= 0) {
                    dp[i] += dp[i - k];
                }
            }
        }
        return dp[tar];
    }

}
