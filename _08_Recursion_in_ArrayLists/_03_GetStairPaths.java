import java.util.ArrayList;
import java.util.Scanner;

public class _03_GetStairPaths {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        ArrayList<String> paths = getStairPaths(n);
        System.out.println(paths);
    }

    private static ArrayList<String> getStairPaths(int n) {

        if (n == 0) {
            ArrayList<String> paths = new ArrayList<>();
            paths.add("");
            return paths;
        }

        ArrayList<String> paths = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            ArrayList<String> ps = getStairPaths(n - i);
            for (String path : ps) {
                paths.add(i + path);
            }
        }

        return paths;
    }
}
