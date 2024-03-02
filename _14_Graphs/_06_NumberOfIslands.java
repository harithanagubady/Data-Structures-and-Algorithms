public class _06_NumberOfIslands {

    public static void main(String[] args) {

        int[][] arr = {{0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0}
        };

        int rows = arr.length, cols = arr[0].length;
        boolean[][] visited = new boolean[rows][cols];

        int noOfIslands = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (arr[i][j] == 0 && !visited[i][j]) { //Skip the visited 0's

                    //Step1: connect Graph Of Zeroes And Marked Nodes of that Graph As Visited
                    connectGraph(arr, i, j, visited);

                    //Step2: increase count by 1
                    noOfIslands++;
                }
            }
        }
        System.out.println(noOfIslands);
    }

    private static void connectGraph(int[][] arr, int i, int j, boolean[][] visited) {

        if (i < 0 || j < 0 || i == arr.length || j == arr[0].length || arr[i][j] == 1 || visited[i][j]) {
            return;
        }
        visited[i][j] = true;
        connectGraph(arr, i - 1, j, visited);
        connectGraph(arr, i, j + 1, visited);
        connectGraph(arr, i + 1, j, visited);
        connectGraph(arr, i, j - 1, visited);
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