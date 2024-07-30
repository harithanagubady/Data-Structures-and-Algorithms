import java.util.Scanner;

/*

n - rows
m - columns
n*m numbers of 2d array and the number is either 0 or 1
start from top-left and reach to bottom right corner.
Only four moves allowed - 't'(1-step up), 'l'(1-step left), 'd'(1-step down), 'r'(1-step right)
You can only move to cells which have 0 value.
You can't move out of the boundaries or in the cells which have 1 (1 means obstacle)
Note: Make moves in the order 't','l','d','r'
 */
public class _01_FloodFill {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = scn.nextInt();
            }
        }
        boolean[][] visited = new boolean[n][m];
        floodfill(arr, 0, 0, "", visited);
    }

    // asf -> answer so far
    public static void floodfill(int[][] maze, int sr, int sc, String asf, boolean[][] visited) {
        if (sr < 0 || sc < 0 || sr > maze.length - 1 || sc > maze[0].length - 1 || maze[sr][sc] == 1 || visited[sr][sc]) {
            return;
        }

        if(sr == maze.length - 1 && sc == maze[0].length - 1) {
            System.out.println(asf);
            return;
        }

        visited[sr][sc]  = true;

        floodfill(maze, sr - 1, sc, asf + "t", visited);
        floodfill(maze, sr, sc - 1, asf + "l", visited);
        floodfill(maze, sr + 1, sc, asf + "d", visited);
        floodfill(maze, sr, sc + 1, asf + "r", visited);

        visited[sr][sc]  = false;
    }
}
