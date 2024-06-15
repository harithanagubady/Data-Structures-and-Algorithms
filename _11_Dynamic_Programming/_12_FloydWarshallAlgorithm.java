public class _12_FloydWarshallAlgorithm {

    static int INF = 99999;
    public static void main(String[] args) {
        int[][] matrix = {{0, 0, 0, 0, 0},
                {0, 0, 3, INF, 7 },
                {0, 8, 0, 2, INF},
                {0, 5, INF, 0, 1},
                {0, 2, INF, INF, 0}};
        int V = 4;

        //A[i,j] = min{A[i,k] + A[k,j], A[i,j]}
        for (int k = 1; k <= V; k++) {
            for (int i = 1; i < matrix.length; i++) {
                for (int j = 1; j < matrix[0].length; j++) {
                    matrix[i][j] = Math.min(matrix[i][j], matrix[i][k] + matrix[k][j]);
                }
            }
        }

        printAllPairsShortestPath(matrix);
    }

    static void printAllPairsShortestPath (int[][] matrix) {
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (i == j) continue;
                System.out.println(i + " -> " + j + " @ " + matrix[i][j]);
            }
        }
    }
}
