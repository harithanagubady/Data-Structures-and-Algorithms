import java.util.Arrays;

public class _06_HamiltonianCycle {

    static int v = 5;
    static int[] x = new int[v + 1];
    static int[][] graph = new int[v + 1][v + 1];

    public static void main(String[] args) {

        graph = new int[][]{{1, 1, 1, 1, 1, 1},
                {1, 0, 1, 1, 0, 1},
                {1, 1, 0, 1, 1, 1},
                {1, 1, 1, 0, 1, 0},
                {1, 0, 1, 1, 0, 1},
                {1, 1, 1, 0, 1, 0}};

        hamiltonian(1);
    }

    private static void hamiltonian(int k) {
        do {
            nextVertex(k);
            if (x[k] == 0) {
                return;
            }
            if (k == v) {
                System.out.println(Arrays.toString(x));
            } else {
                hamiltonian(k + 1);
            }
        } while (true);
    }

    private static void nextVertex(int k) {
        do {
            x[k] = (x[k] + 1) % (v + 1);
            if (x[k] == 0) {
                return;
            }
            if (graph[x[k - 1]][x[k]] == 1) {
                int j;
                for (j = 1; j <= k - 1; j++) {
                    if (x[j] == x[k]) break;
                }
                if (j == k) {
                    if (k < v || (k == v && graph[x[v]][x[1]] == 1)) {
                        return;
                    }
                }
            }
        } while (true);
    }
}
