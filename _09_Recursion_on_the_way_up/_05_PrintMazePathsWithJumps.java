import java.util.Scanner;

public class _05_PrintMazePathsWithJumps {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        printMazePathsWithJumps(1, 1, n, m, "");
    }

    private static void printMazePathsWithJumps(int sr, int sc, int dr, int dc, String psf) {

        if (sr == dr && sc == dc) {
            System.out.println(psf);
            return;
        }

        for (int hi = 1; hi <= dc - sc; hi++) {
            printMazePathsWithJumps(sr, sc + hi, dr, dc, "h" + hi + psf);
        }


        for (int vi = 1; vi <= dr - sr; vi++) {
            printMazePathsWithJumps(sr + vi, sc, dr, dc, "v" + vi + psf);
        }


        for (int di = 1; di <= dr - sr && di <= dc - sc; di++) {
            printMazePathsWithJumps(sr + di, sc + di, dr, dc, "d" + di + psf);
        }
    }
}
