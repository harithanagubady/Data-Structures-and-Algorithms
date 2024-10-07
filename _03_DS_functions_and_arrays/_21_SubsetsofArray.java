import java.util.*;

/*
Print all subarrays of array in the given format
eg: [10, 20, 30]
o/p:
-   -   -
-   -   30
-   20  -
-   20  30
10  -   -
10  -   30
10  20  -
10  20  30

 */
public class _21_SubsetsofArray {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        int limit = (int) Math.pow(2, n);
        for (int i = 0; i < limit; i++) {
            int temp = i;
            StringBuilder substr = new StringBuilder();
            for (int j = n - 1; j >= 0; j--) {
                if (temp % 2 == 1) {
                    substr.insert(0, arr[j] + "\t");
                } else {
                    substr.insert(0, "-" + "\t");
                }
                temp /= 2;
            }
            System.out.println(substr);
        }
    }

}

//Time complexity: O(2^n * n^2)
//There is an efficient approach using backtracking which will be solved later