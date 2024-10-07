/*
https://leetcode.com/problems/richest-customer-wealth/description/
 */

package _01_MatrixTraversal;

public class _04_LC1672_RichestCustomerWealth {

    public int maximumWealth(int[][] accounts) {
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

    }
}
