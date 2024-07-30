import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*

 */
public class _06_HamiltonianCycleApproach2 {
    static List<List<Integer>> allCycles = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        int v = 5;
        int[][] graph = new int[][]{
                {0, 1, 1, 0, 1},
                {1, 0, 1, 1, 1},
                {1, 1, 0, 1, 0},
                {0, 1, 1, 0, 1},
                {1, 1, 0, 1, 0}};
        int[] visited = new int[v];
        Arrays.fill(visited, -1);
        visited[0] = 0;
        getHamiltonianPaths(graph, visited, 1, v);

        for (List<Integer> cycle : allCycles) {
            for (int e : cycle) {
                System.out.print(e);
            }
            System.out.println();
        }
    }

    private static void getHamiltonianPaths(int[][] graph, int[] path, int pos, int V) {
        if (pos == V) {
            // Check if there is an edge from the last vertex to the starting vertex
            if (graph[path[pos - 1]][path[0]] == 1) {
                List<Integer> cycle = new ArrayList<>();
                for (int i = 0; i < V; i++) {
                    cycle.add(path[i]);
                }
                cycle.add(path[0]); // Add the starting vertex again to complete the cycle
                allCycles.add(cycle);
            }
            return;
        }

        // Try different vertices as a next candidate in the Hamiltonian Cycle
        for (int v = 1; v < V; v++) {
            // Check if this vertex can be added to Hamiltonian Cycle
            if (isSafe(graph, path, pos, v, V)) {
                path[pos] = v;

                // Recur to construct rest of the path
                getHamiltonianPaths(graph, path, pos + 1, V);

                // Backtrack
                path[pos] = -1;
            }
        }
    }

    private static boolean isSafe(int[][] graph, int[] path, int pos, int v, int V) {
        if (graph[path[pos - 1]][v] == 0) {
            return false; // Check if there is an edge from the last vertex in path to v
        }

        for (int i = 0; i < pos; i++) {
            if (path[i] == v) {
                return false; // Check if v is already included in the path
            }
        }

        return true;
    }
}

/*

7
9
0 1
1 2
2 3
2 5
0 3
3 4
4 5
5 6
4 6
0
 */