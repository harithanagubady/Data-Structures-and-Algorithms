import java.util.ArrayList;
import java.util.Scanner;

public class _03_PrintStairPaths {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        printStairPaths(n, "");
    }

    private static void printStairPaths(int n, String ans) {

        if (n == 0) {
            System.out.println(ans);
            return;
        }

        ArrayList<String> paths = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            printStairPaths(n - i, i + ans);
        }
    }
}
