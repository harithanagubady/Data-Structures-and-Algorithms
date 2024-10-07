import java.util.Scanner;

/*
https://leetcode.com/problems/remove-element/description/
 */
public class _22_LC27_RemoveElement {

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        int d = scn.nextInt();

        int k = removeElement(arr, d);
        for (int i = 0; i < k; i++) {
            System.out.println(arr[i]);
        }
    }

    private static int removeElement(int[] arr, int d) {
        int k = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != d) {
                arr[k++] =  arr[i];
            }
        }
        return k;
    }
}
