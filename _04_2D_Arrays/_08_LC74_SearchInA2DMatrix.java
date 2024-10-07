/*
https://leetcode.com/problems/search-a-2d-matrix/description/
 */
import java.util.Scanner;

public class _08_LC74_SearchInA2DMatrix {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = scn.nextInt();
            }
        }

        int num = scn.nextInt();

        System.out.println(solution1(arr, num));
        System.out.println(solution2(arr, num));
        System.out.println(solution3(arr, num));
    }

    //O(log(mn))
    private static boolean solution1 (int[][] matrix, int tar) {
        int n = matrix.length;
        int m = matrix[0].length;

        int top = 0, bottom = n - 1;

        while (top <= bottom) {
            int mid = top + (bottom - top) / 2;

            if (matrix[mid][0] == tar) {
                return true;
            } else if (matrix[mid][0] < tar){

                if ((mid < n - 1 && matrix[mid + 1][0] > tar) || mid == n - 1) {
                    return bs(mid, matrix, tar, 0, m - 1);
                }
                top = mid + 1;
            } else {

                if (mid > 0 && matrix[mid - 1][0] < tar) {
                    return bs(mid - 1, matrix, tar, 0, m - 1);
                } else if (mid == 0) {
                    return bs (mid, matrix, tar, 0, m - 1);
                }
                bottom = mid - 1;
            }
        }
        return false;
    }

    private static boolean bs (int i, int[][] matrix, int tar, int l, int r) {
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (matrix[i][mid] == tar) {
                return true;
            } else if (matrix[i][mid] < tar) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return false;
    }

    //O(n + m)
    private static boolean solution2 (int[][] matrix, int tar) {
        int n = matrix.length, m = matrix[0].length;
        int i = 0, j = m - 1;
        int count = n * m;
        while (count-- > 0 && i >= 0 && i < n && j >= 0 && j < m) {
            if (matrix[i][j] == tar) {
                return true;
            } else if (matrix[i][j] < tar) {
                i++;
            } else {
                j--;
            }
        }
        return false;
    }

    private static boolean solution3(int[][] matrix, int tar) {
        int n = matrix.length, m = matrix[0].length;
        int left = 0, right = n * m - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int elem = matrix[mid/m][mid%m];
            if (elem == tar) return true;
            if (elem < tar) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return false;
    }
}

/*
3
4
11
12
13
14
21
22
23
24
31
32
33
34
32
 */