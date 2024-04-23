/*

Get all stair paths for 0 to 6 with step size of 1, 2, or 3 in a single move
111111
222
33
1212
3111
so on...
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class _03_GetStairPathsDp {

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[]{1, 2, 3};
        HashMap<Integer, ArrayList<String>> dp = new HashMap<>();
        ArrayList<String> stairPaths = getStairPaths(n, arr, dp);
        System.out.println(stairPaths);
    }

    //Get Stair Paths with DP and step/jump size 1, 2, 3
    private static ArrayList<String> getStairPaths(int src, int[] arr, HashMap<Integer, ArrayList<String>> dp) {

        if (src == 0) {
            ArrayList<String> list = new ArrayList<>();
            list.add("");
            return list;
        }

        if (src < 0) {
            return new ArrayList<>();
        }

        if (dp.containsKey(src)) {
            return dp.get(src);
        }

        ArrayList<String> paths = new ArrayList<>();
        for (int j : arr) {
            ArrayList<String> subStairPaths1 = getStairPaths(src - j, arr, dp);
            for (String s : subStairPaths1) {
                paths.add(j + s);
            }
        }
        dp.put(src, paths);
        return paths;
    }
}
