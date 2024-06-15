import java.util.ArrayList;
import java.util.List;

public class _11_MultiStageGraph {

    public static void main(String[] args) {
        // Example graph
        List<List<Pair>> graph = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            graph.add(new ArrayList<>());
        }

        graph.get(1).add(new Pair(2, 9));
        graph.get(1).add(new Pair(3, 7));
        graph.get(1).add(new Pair(4, 6));
        graph.get(1).add(new Pair(5, 2));
        graph.get(2).add(new Pair(6, 4));
        graph.get(2).add(new Pair(7, 2));
        graph.get(2).add(new Pair(8, 1));
        graph.get(3).add(new Pair(6, 2));
        graph.get(3).add(new Pair(7, 7));
        graph.get(4).add(new Pair(8, 11));
        graph.get(5).add(new Pair(7, 11));
        graph.get(5).add(new Pair(8, 8));
        graph.get(6).add(new Pair(9, 6));
        graph.get(6).add(new Pair(10, 5));
        graph.get(7).add(new Pair(9, 4));
        graph.get(7).add(new Pair(10, 3));
        graph.get(8).add(new Pair(10, 5));
        graph.get(8).add(new Pair(11, 6));
        graph.get(9).add(new Pair(12, 4));
        graph.get(10).add(new Pair(12, 2));
        graph.get(11).add(new Pair(12, 5));

        // Find the shortest path from vertex 0 to vertex 11
        // (changed target from 12 to 11)
        int noOfStages = 5;
        int src = 1;
        int shortestPathDistance
                = multistageShortestPath(graph, src, noOfStages);
        System.out.println(
                "Shortest path distance from vertex 1 to vertex 12: "
                        + shortestPathDistance);
    }

    private static int multistageShortestPath(List<List<Pair>> graph, int src, int k) {

        int n = graph.size();
        int[][] table = new int[n + 1][2]; //[cost,d]

        for (int i = 0; i < table.length; i++) {
            table[i][0] = Integer.MAX_VALUE;
            table[i][1] = i;
        }

        table[n][0] = 0;

        //Formula: cost[stage, curr] = min {d(curr, dest) + cost[stage + 1, dest]
        for (int v = n - 1; v >= 1; v--) {
            for (Pair edge : graph.get(v)) {
                if (table[v][0] > table[edge.vertex][0] + edge.weight) {
                    table[v][0] = table[edge.vertex][0] + edge.weight;
                    table[v][1] = edge.vertex;
                }
            }
        }
        int[] path = new int[k + 1];
        path[1] = 1;
        path[k] = n;
        for (int i = 2; i < k; i++) {
            path[i] = table[path[i-1]][1];
        }
        System.out.println("Path: ");
        for (int i = 1; i <= k; i++) {
            System.out.print(path[i] + " ");
        }
        System.out.println();
        return table[src][0];
    }

    static class Pair {
        int vertex;
        int weight;

        public Pair(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }
    }
}
