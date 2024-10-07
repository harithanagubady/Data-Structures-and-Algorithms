import java.util.*;

/*
Print inverted bar chart
eg:
input:
5
4
5
1
0
7
output:
*	*	*		*
*	*			*
*	*			*
*	*			*
	*			*
				*
				*
 */
public class _20_InvertedBarChart {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
            max = Math.max(max, arr[i]);
        }

        for (int i = 0; i < max; i++) {
            for (int j = 0; j < n; j++) {
                if (i < arr[j]) {
                    System.out.print("*\t");
                } else {
                    System.out.print("\t");
                }
            }
            System.out.println();
        }
    }
}