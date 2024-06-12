import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;

//Shortest path connecting all nodes | Minimum Spanning Tree
public class _15_MST_Prims {

    public static class Edge {
        int src;
        int nbr;
        int wt;

        public Edge(int src, int nbr, int wt) {
            this.src = src;
            this.nbr = nbr;
            this.wt = wt;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int v = Integer.parseInt(bf.readLine());
        ArrayList<Edge>[] graph = new ArrayList[v];
        for (int i = 0; i < v; i++) {
            graph[i] = new ArrayList<>();
        }

        int e = Integer.parseInt(bf.readLine());
        for (int i = 0; i < e; i++) {
            String[] s = bf.readLine().split(" ");
            int v1 = Integer.parseInt(s[0]);
            int v2 = Integer.parseInt(s[1]);
            int wt = Integer.parseInt(s[2]);
            graph[v1].add(new Edge(v1, v2, wt));
            graph[v2].add(new Edge(v2, v1, wt));
        }

        int src = Integer.parseInt(bf.readLine());

        boolean[] visited = new boolean[v];
        primsMethod(graph, src, visited);
    }

    private static void primsMethod(ArrayList<Edge>[] graph, int src, boolean[] visited) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(src, -1, 0));

        while (pq.size() > 0) {
            Pair rem = pq.remove();
            if (visited[rem.v]) {
                continue;
            }
            visited[rem.v] = true;
            if (rem.pv != -1)
                System.out.println(rem.pv + " - " + rem.v + " @ " + rem.wt);
            for (Edge e : graph[rem.v]) {
                if (!visited[e.nbr]) {
                    pq.add(new Pair(e.nbr, rem.v, e.wt));
                }
            }
        }
    }

    static class Pair implements Comparable<Pair>{
        int v;
        int pv;
        int wt;

        public Pair (int v, int pv, int wt) {
            this.v = v;
            this.pv = pv;
            this.wt = wt;
        }


        @Override
        public int compareTo(Pair o) {
            return this.wt - o.wt;
        }
    }
}

/*

5
6
0 1 5
1 2 6
2 3 1
0 4 4
0 3 3
3 4 2
0

 2 - 3 - 4
 |   |  /
 1 - 0
 */