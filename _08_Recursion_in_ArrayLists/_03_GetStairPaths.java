import java.util.ArrayList;
import java.util.Scanner;

/*
Get all stair paths for 0 to 6 with step size of 1, 2, or 3 in a single move
        111111
        222
        33
        1212
        3111
        so on...
        */
public class _03_GetStairPaths {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[]{1, 2, 3};
        ArrayList<String> paths = getStairPaths(n, arr);
        System.out.println(paths);
    }

    private static ArrayList<String> getStairPaths(int src, int[] arr) {

        if (src == 0) {
            ArrayList<String> list = new ArrayList<>();
            list.add("");
            return list;
        }

        if (src < 0) {
            return new ArrayList<>();
        }

        ArrayList<String> paths = new ArrayList<>();
        for (int j : arr) {
            ArrayList<String> subStairPaths1 = getStairPaths(src - j, arr);
            for (String s : subStairPaths1) {
                paths.add(j + s);
            }
        }
        return paths;
    }
}
