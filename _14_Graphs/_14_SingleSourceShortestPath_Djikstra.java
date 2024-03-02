import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class _14_SingleSourceShortestPath_Djikstra {

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
        shortestPath(graph, src, visited);
    }

    //Djikstra's Algorithm
    private static void shortestPath(ArrayList<Edge>[] graph, int src, boolean[] visited) {

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(src, "" + src, 0));

        while (pq.size() > 0) {
            Pair rem = pq.remove();

            if (visited[rem.v]) {
                continue;
            }

            System.out.println(rem.v + " --> " + rem.psf + " @ " + rem.wsf);
            visited[rem.v] = true;

            for (Edge e : graph[rem.v]) {
                if (!visited[e.nbr]) {
                    pq.add(new Pair(e.nbr, rem.psf + e.nbr, rem.wsf + e.wt));
                }
            }
        }
    }

    public static class Pair implements Comparable<Pair> {

        int v;
        String psf;
        int wsf;


        public Pair(int v, String psf, int wsf) {
            this.v = v;
            this.psf = psf;
            this.wsf = wsf;
        }

        @Override
        public int compareTo(Pair o) {
            return this.wsf - o.wsf;
        }
    }
}

/*

7
8
0 1 10
1 2 10
2 3 10
0 3 31
3 4 2
4 5 3
5 6 3
4 6 4
0

 */