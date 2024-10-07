/*
https://www.youtube.com/watch?v=85gIj4eBdBA&list=PL-Jc9J83PIiFj7YSPl2ulcpwy-mwj1SSk&index=97
A bar chart of asterisks representing value of array
[3, 1, 0, 7, 5]
            *
            *
            *   *
            *   *
*           *   *
*           *   *
*   *       *   *

 */
public class _10_BarChart {

    public static void main(String[] args) throws Exception {
        int n = 5;
        int[] arr = {3, 1, 0, 7, 5};
        printBarChart(arr);
    }

    public static void printBarChart(int[] arr) {
        int max = findMax(arr);
        for (int i = max; i >= 1; i--) {
            for (int k : arr) {
                if (i <= k) {
                    System.out.print("*\t");
                } else {
                    System.out.print("\t");
                }
            }
            System.out.println();
        }
    }

    private static int findMax(int[] arr) {
        int max = 0;
        for (int i : arr) {
            if (max < i) {
                max = i;
            }
        }
        return max;
    }


}