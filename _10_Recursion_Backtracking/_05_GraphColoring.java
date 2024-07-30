
/*
https://www.geeksforgeeks.org/graph-coloring-applications/
 */
public class _05_GraphColoring {
    public static void main(String[] args) {

        //provide graph using adjacency matrix
        boolean[][] graph = {{false, true, true, true},
                {true, false, true, true},
                {true, true, false, false},
                {true, true, false, false}
        };
        int m = 3;
        int V = 4;
        printGraphColors(graph, m, V);
    }

    private static void printGraphColors(boolean[][] graph, int m, int V) {
        int[] colors = new int[V];
        if (!graphColoringUtil (graph, colors, m, 0, V)) {
            System.out.println("Coloring is not possible");
        }
    }

    private static boolean graphColoringUtil(boolean[][] graph, int[] colors, int m, int v, int V) {
        if (v == V) {
            printSolution(colors);
            return true;
        }
        for (int c = 1; c <= m; c++) {
            if (isSafe(graph, colors, c, v, V)) {
                colors[v] = c;
                if (graphColoringUtil(graph, colors, c, v + 1, V)) {
                    return true;
                }
                colors[v] = 0;
            }
        }
        return false;
    }

    private static void printSolution(int[] colors) {
        System.out.println("Solution Exists...");
        for (int i : colors) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    private static boolean isSafe(boolean[][] graph, int[] colors, int c, int v, int V) {
        for (int i = 0; i < V; i++) {
            if (graph[v][i] && colors[i] == c) {
                return false;
            }
        }
        return true;
    }
}
