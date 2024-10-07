package _01_MatrixTraversal;

/*
https://leetcode.com/problems/count-negative-numbers-in-a-sorted-matrix/description/
 */
public class _07_LC1351_CountNegativesInSortedMatrix {

    public static void main(String[] args) {

        int[][] matrix = {{4, 3, 2, -1},
                {3, 2, 1, -1},
                {1, 1, -1, -2},
                {-1, -1, -2, -3}};

        System.out.println(countNegativesUsingBinarySearch(matrix));
        System.out.println(countNegatives2(matrix));

    }

    //O(mlogn) solution
    public static int countNegativesUsingBinarySearch(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int res = 0, lastNeg = n - 1;
        for (int row = 0; row < m; row++) {
            //check edge cases - if first element is < 0 - all elements in row are negative
            if (grid[row][0] < 0) {
                res+=n;
                continue;
            }
            //if last element is positive - it means there are no negative numbers in a row
            if (grid[row][n - 1] > 0)
                continue;
            //there is a mix of negative and positive ones, need to find the border. starting
            //binary search
            int l = 0, r = lastNeg;
            while (l <= r) {
                int mid = l + (r - l)/2;
                if (grid[row][mid] < 0) {
                    r = mid - 1;
                } else
                    l = mid + 1;
            }
            //l points to the first negative element, which means cols - l is a number of
            //such elements
            res += (n - l);
            lastNeg = l;
        }
        return res;
    }

    //Optimal O(m + n) solution
    /*
    decreasing order in both rows and cols results in a staircase type of positive/negative numbers
    negative numbers grow from row to row with variation from 0 to n
     */
    public static int countNegatives2(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int i = m - 1, j = 0;
        int count = 0;
        //start from bottom-left
        while (i >= 0 && j < n) {
            if (grid[i][j] < 0) {
                count += (n - j);
                i--;
                continue;
            }
            j++;
        }
        return count;
    }
}
