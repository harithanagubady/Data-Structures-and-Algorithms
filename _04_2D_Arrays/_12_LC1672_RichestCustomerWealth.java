/*

https://leetcode.com/problems/richest-customer-wealth/
 */

public class _12_LC1672_RichestCustomerWealth {

    public static int maximumWealth(int[][] accounts) {
        int maxWealth = 0;
        for (int[] i : accounts) {
            int sum = 0;
            for (int j : i) {
                sum += j;
            }
            if (maxWealth < sum) {
                maxWealth = sum;
            }
        }
        return maxWealth;
    }

    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3}, {3, 2, 1}};
        System.out.println(maximumWealth(arr));
    }
}
