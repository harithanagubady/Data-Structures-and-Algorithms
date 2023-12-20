import java.util.LinkedList;
import java.util.Queue;

public class _994_Solution {


    public static void main(String[] args) {
        int arr[][] = {{2, 1, 0, 2, 1},
                {1, 0, 1, 2, 1},
                {1, 0, 0, 2, 1}};
        int ans = rotOranges(arr);
        if (ans == -1)
            System.out.println("All oranges cannot rot");
        else
            System.out.println(
                    "Time required for all oranges to rot => "
                            + ans);
    }


    public static int rotOranges(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        int freshCount = 0;
        int minutes = 0;

        // Initialize queue with initially rotten apples and count fresh apples
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    freshCount++;
                }
            }
        }

        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        // BFS to rot neighboring fresh apples
        while (!queue.isEmpty() && freshCount > 0) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                for (int[] dir : directions) {
                    int newX = curr[0] + dir[0];
                    int newY = curr[1] + dir[1];
                    if (newX >= 0 && newX < grid.length && newY >= 0 && newY < grid[0].length
                            && grid[newX][newY] == 1) {
                        grid[newX][newY] = 2;
                        queue.offer(new int[]{newX, newY});
                        freshCount--;
                    }
                }
            }
            minutes++;
        }

        return freshCount == 0 ? minutes : -1; // Return minutes or -1 if some apples remain fresh
    }
}