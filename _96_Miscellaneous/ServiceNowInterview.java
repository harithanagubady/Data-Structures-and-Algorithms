import java.util.*;

public class ServiceNowInterview {

    /*

    { {1, 2, 3},  00, 01, 02
      {4, 5, 6},  10, 11, 12
      {7, 8, 9} } 20, 21, 22
     */

    // (row, col + 1), (row + 1, col)
    // Queue : {10, 11, 20, 12,
    // Solution : {00, 01, 10, 02,
    // hashmap("10", true) :
    // 00, 01, 10, 02, 11, 20, 12, 21, 22
    //i -> 0 to n - 1 , sum -> 0 to 2(n-1)
    static class Pair {
        int row;
        int col;

        public Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
    public static void main(String[] args) {

        int n = 3;
        int[][] mat = {{1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};
        Queue<Pair> q = new LinkedList<>();
        boolean[][] visited = new boolean[n][n];
        List<Integer> list = new ArrayList<>();
        q.add(new Pair(0, 0));
        while (q.size() > 0) {
            Pair s = q.remove();
            int i = s.row;
            int j = s.col;

            if (visited[i][j]) {
                continue;
            }
            visited[i][j] = true;
            list.add(mat[i][j]);

            if (j + 1 < n && !visited[i][j + 1]) {
                q.add(new Pair(i, j+1));
            }

            if (i + 1 < n && !visited[i + 1][j]) {
                q.add(new Pair(i + 1, j));
            }
        }
        list.forEach(System.out::println);
    }
}
