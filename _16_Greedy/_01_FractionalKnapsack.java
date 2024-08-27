import java.util.Arrays;

public class _01_FractionalKnapsack {

    public static void main(String[] args) {
        int[][] arr = {{2, 10}, {3, 5}, {5, 15}, {7, 7}, {1, 6}, {4, 18}, {1, 3}}; //{W, P}, W - Weight, P - Profit
        int tar = 15;
        System.out.println(maximumProfit(arr, tar));
    }

    private static double maximumProfit(int[][] arr, int tar) {

        Arrays.sort(arr, (a, b) -> a[1] * b[0] - a[0] * b[1]);//ascending order //{P(a)*W(b) - W(a)*P(b)} or {(P(a)/W(a) > P(b)/W(b)}
        int n = arr.length;
        double res = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (tar >= arr[i][0]) {
                res += arr[i][1];
                tar -= arr[i][0];
            } else {
                res += ((double)arr[i][1] / (double)arr[i][0]) * (double)tar;
                tar = 0;
                break;
            }
        }
        return res;
    }
}
