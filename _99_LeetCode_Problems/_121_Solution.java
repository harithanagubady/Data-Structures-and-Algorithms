public class _121_Solution {

    public static void main(String[] args) {
        /*
        Closing prices - 100,95,93, 96,93,100,105,98,105,100,95,93, 96,93,100,105,98,105, 95,93, 96,93,91
         */

        int[] arr = {100, 95, 93, 96, 97, 100, 105, 91, 110};

        int[] ans = buyAndSellStocks(arr);

        System.out.println("Best day to buy: " + ans[0]);
        System.out.println("Best day to sell: " + ans[1]);
        System.out.println("Profit: " + ans[2]);
    }

    public static int[] buyAndSellStocks(int[] arr) {
        int n = arr.length;
        int buy = 0, sell = 1, maxBuy = buy, maxSell = sell;
        int profit = Integer.MIN_VALUE, maxProfit = Integer.MIN_VALUE;
        int[] ans = new int[3];
        while (sell < n) { //100, 95, 93, 96, 97, 100, 105, 91
            System.out.println(arr[buy] + " " + arr[sell]);
            if (arr[buy] > arr[sell]) {
                if (profit > maxProfit) {
                    maxProfit = profit;
                    ans[0] = maxBuy;
                    ans[1] = maxSell;
                    ans[2] = maxProfit;
                }
                buy++;
                sell = buy + 1;
            } else {
                profit = arr[sell] - arr[buy]; // 3
                maxBuy = buy; // 2
                maxSell = sell; // 3
                sell++; // 4
            }
        }
        if (profit > maxProfit) {
            maxProfit = profit;
            ans[0] = maxBuy;
            ans[1] = maxSell;
            ans[2] = maxProfit;
        }
        return ans;
    }
}
