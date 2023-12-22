import java.util.ArrayList;
import java.util.Scanner;

public class _05_GetMazePathsWithJumps {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        System.out.println(getMazePathsWithJumps(1, 1, n, m));
    }

    private static ArrayList<String> getMazePathsWithJumps(int sr, int sc, int dr, int dc) {

        if (sr == dr && sc == dc) {
            ArrayList<String> newList = new ArrayList<>();
            newList.add("");
            return newList;
        }

        if (sr > dr || sc > dc) {
            return new ArrayList<>();
        }

        ArrayList<String> paths = new ArrayList<>();


        for (int hi = 1; hi <= dc - sc; hi++) {
            ArrayList<String> hpaths = getMazePathsWithJumps(sr, sc + hi, dr, dc);
            for (String hpath : hpaths) {
                paths.add("h" + hi + hpath);
            }
        }


        for (int vi = 1; vi <= dr - sr; vi++) { //size of jump
            ArrayList<String> vpaths = getMazePathsWithJumps(sr + vi, sc, dr, dc);
            for (String vpath : vpaths) {
                paths.add("v" + vi + vpath);
            }
        }


        for (int di = 1; di <= dr - sr && di <= dc - sc; di++) {
            ArrayList<String> dpaths = getMazePathsWithJumps(sr + di, sc + di, dr, dc);
            for (String dpath : dpaths) {
                paths.add("d" + di + dpath);
            }
        }

        return paths;
    }
}
