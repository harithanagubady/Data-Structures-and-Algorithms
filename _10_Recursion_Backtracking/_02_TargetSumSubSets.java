import java.util.Scanner;

public class _02_TargetSumSubSets {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
            sum += arr[i];
        }
        int tar = scn.nextInt();
        printTargetSumSubsets(arr, 0, tar, "", 0, sum);
    }

    //static int count = 1;

    public static void printTargetSumSubsets(int[] arr, int idx, int tar, String set, int sum, int remSum) {

        if (sum == tar) {
            System.out.println(set + "\b\b");
            return;
        }

        if (idx == arr.length) {
            return;
        }

        int newRemSum = remSum - arr[idx];
        int newSum = sum + arr[idx];

        //System.out.println(count++);
        //next recursion calls happen only if following condition is met
        //newSum + newRemSum >= tar
        if (newSum + newRemSum >= tar) {
            //only include if newSum is less than or equal to target
            if (newSum <= tar) {
                //System.out.println("include: " + arr[idx] + "\t" + newSum + " | " + newRemSum);
                printTargetSumSubsets(arr, idx + 1, tar, set + arr[idx] + ", ", newSum, newRemSum);
            }
            //System.out.println("exclude: " + arr[idx] + "\t" + sum + " | " + newRemSum);
            printTargetSumSubsets(arr, idx + 1, tar, set, sum, newRemSum);
        }
    }
}

/*
Before Bounding Function
For below input, we get {15, 10, 5} after 19 recursive calls
we get {30} after 58 recursive calls
and 1 another recursive call

After Bounding Function
For below input, we get {15, 10, 5} after 4 recursive calls
we get {30} after 31 recursive calls
and 1 another recursive call
*/

/*
input:
6
15
18
10
5
30
1
30

 */