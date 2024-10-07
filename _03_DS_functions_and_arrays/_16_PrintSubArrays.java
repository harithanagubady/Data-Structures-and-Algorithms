import java.util.Scanner;

public class _16_PrintSubArrays {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        for (int left = 0; left < n; left++) {
            for (int right = left; right < n; right++) {
                for (int k = left; k <= right; k++) {
                    System.out.print(arr[k] + "\t");
                }
                System.out.println();
            }
        }
    }

}