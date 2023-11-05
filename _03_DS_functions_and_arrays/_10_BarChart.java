import java.io.*;

public class _10_BarChart {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = 5;
        int[] arr = {3, 1, 0, 7, 5};


        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {

            max = Math.max(max, arr[i]);
        }


        for (int y = 0; y < max; y++) {
            for (int x : arr) {
                if (x >= max - y) {
                    System.out.print("*	");
                } else {
                    System.out.print("	");
                }
            }
            System.out.println();
        }
    }

}