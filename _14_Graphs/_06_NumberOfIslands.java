import java.util.LinkedList;
import java.util.Queue;

/*
https://leetcode.com/problems/number-of-islands/
 */
public class _06_NumberOfIslands {

    public static void main(String[] args) {

        int[][] arr = {{1, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 0},
                {0, 0, 0, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0}
        };

        int rows = arr.length, cols = arr[0].length;
        boolean[][] visited = new boolean[rows][cols];

        int noOfIslands = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (arr[i][j] == 1 && !visited[i][j]) { //Skip the visited 0's

                    //Step1: connect Graph Of Zeroes And Marked Nodes of that Graph As Visited
                    connectGraphBFS(arr, i, j, visited);

                    //Step2: increase count by 1
                    noOfIslands++;
                }
            }
        }
        System.out.println(noOfIslands);
    }

    private static void connectGraphDFS(int[][] arr, int i, int j, boolean[][] visited) {

        if (i < 0 || j < 0 || i == arr.length || j == arr[0].length || arr[i][j] == 0 || visited[i][j]) {
            return;
        }
        visited[i][j] = true;
        connectGraphDFS(arr, i - 1, j, visited);
        connectGraphDFS(arr, i, j + 1, visited);
        connectGraphDFS(arr, i + 1, j, visited);
        connectGraphDFS(arr, i, j - 1, visited);
    }

    private static void connectGraphBFS(int[][] arr, int i, int j, boolean[][] visited) {

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {i, j});
        while (q.size() > 0) {

            int[] a = q.remove();
            int row = a[0];
            int col = a[1];

            if (row < 0 || col < 0 || row == arr.length || col == arr[0].length || arr[row][col] == 0 || visited[row][col]) {
                continue;
            }

            visited[row][col] = true;
            q.add(new int[] {row - 1, col});
            q.add(new int[] {row, col + 1});
            q.add(new int[] {row + 1, col});
            q.add(new int[] {row, col - 1});
        }
    }
}

/*

{{0, 0, 1, 1, 1, 1, 1, 1},
 {0, 0, 1, 1, 1, 1, 1, 1},
 {1, 1, 1, 1, 1, 1, 1, 0},
 {1, 1, 0, 0, 0, 1, 1, 0},
 {1, 1, 1, 1, 0, 1, 1, 0},
 {1, 1, 1, 1, 0, 1, 1, 0},
 {1, 1, 1, 1, 1, 1, 1, 0},
 {1, 1, 1, 1, 1, 1, 1, 0}
}
 */