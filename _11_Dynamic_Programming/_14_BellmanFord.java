import java.util.ArrayList;
import java.util.Arrays;

//Single Source Shortest Path Algorithm
public class _14_BellmanFord {

    public static void main(String[] args) {
        //int v = 7;
        ArrayList<Edge> edges = new ArrayList();
//        edges.add(new Edge(1, 2, 6));
//        edges.add(new Edge(1, 3, 5));
//        edges.add(new Edge(1, 4, 5));
//        edges.add(new Edge(3, 2, -2));
//        edges.add(new Edge(4, 3, -2));
//        edges.add(new Edge(2, 5, -1));
//        edges.add(new Edge(3, 5, 1));
//        edges.add(new Edge(4, 6, -1));
//        edges.add(new Edge(6, 7, 3));
//        edges.add(new Edge(5, 7, 3));

        int v = 4;
        edges.add(new Edge(1, 2, 4));
        edges.add(new Edge(1, 4, 5));
        edges.add(new Edge(2, 4, 5));
        edges.add(new Edge(3, 2, -10));
        edges.add(new Edge(4, 3, 3));
        singleSourceShortestPath (edges, v);
    }

    static int INF = 99999;
    static boolean relaxed;
    //Cost[u] + C[i,j] < Cost[v]
    private static void singleSourceShortestPath(ArrayList<Edge> edges, int v) {

        int k = v - 1;
        int[] cost = new int[v + 1];
        Arrays.fill(cost, INF);
        cost[1] = 0;
        while (k-- > 0) {
            for (Edge e : edges) {
                relax (e, cost);
            }
        }

        for (int i = 1; i < v + 1; i++) {
            System.out.print(cost[i] + " ");
        }
        System.out.println();

        detectNegativeWeightCycle(edges, cost);
    }

    private static void detectNegativeWeightCycle(ArrayList<Edge> edges, int[] cost) {
        relaxed = false;
        //detect negative cycle
        //perform relaxation one more time
        int[] cost1 = Arrays.copyOf(cost, cost.length);
        for (Edge e : edges) {
            relax (e, cost1);
        }
        if (relaxed) {
            System.out.println("There is negative edge cycle present...");
        } else {
            System.out.println("No negative cycle present...");
        }
    }

    private static void relax(Edge e, int[] cost) {
        int d = cost[e.src] + e.wt;
        if (d < cost[e.dest]) {
            cost[e.dest] = d;
            relaxed = true;
        }
    }

    static class Edge {
        int src;
        int dest;
        int wt;

        public Edge (int src, int dest, int wt) {
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }
    }

}
