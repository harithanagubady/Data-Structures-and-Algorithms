import java.util.ArrayList;
import java.util.Scanner;

public class _04_GetMazePaths {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        ArrayList<String> paths = getMazePaths(1, 1, n, m);
        System.out.println(paths);
    }

    private static ArrayList<String> getMazePaths(int sr, int sc, int dr, int dc) {

        if (sr == dr && sc == dc) {
            ArrayList<String> paths = new ArrayList<>();
            paths.add("");
            return paths;
        }

        ArrayList<String> paths1 = new ArrayList<>();
        ArrayList<String> paths2 = new ArrayList<>();
        if (sc < dc) {
            paths1 = getMazePaths(sr, sc + 1, dr, dc);
        }
        if (sr < dr) {
            paths2 = getMazePaths(sr + 1, sc, dr, dc);
        }

        ArrayList<String> paths = new ArrayList<>();

        for (String path : paths1) {
            paths.add("h" + path);
        }
        for (String path : paths2) {
            paths.add("v" + path);
        }
        return paths;
    }
}
