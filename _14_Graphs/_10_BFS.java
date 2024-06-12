import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class _10_BFS {

    static class Edge {
        int src;
        int nbr;

        public Edge(int src, int nbr) {
            this.src = src;
            this.nbr = nbr;
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
            graph[v1].add(new Edge(v1, v2));
            graph[v2].add(new Edge(v2, v1));
        }
        int n = Integer.parseInt(bf.readLine());

        boolean[] visited = new boolean[v];
        BFS(graph, n, visited);
        int[] parent = new int[v];
        Arrays.fill(parent, -1);
        BFSMarkingParent(graph, n, parent);
        int[] parent1 = new int[v];
        Arrays.fill(parent1, -1);
        BFSMarkingParent2(graph, n, parent1);
    }

    static class Pair {
        int e;
        String psf;

        public Pair(int e, String psf) {
            this.e = e;
            this.psf = psf;
        }
    }

    private static void BFS(ArrayList<Edge>[] graph, int i, boolean[] visited) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(i, "" + i));
        while (q.size() > 0) {

            Pair prevPair = q.remove();

            if (visited[prevPair.e]) {
                continue;
            }
            visited[prevPair.e] = true;

            System.out.println(prevPair.e + "@" + prevPair.psf);
            for (Edge e : graph[prevPair.e]) {

                if (!visited[e.nbr]) {
                    q.add(new Pair(e.nbr, prevPair.psf + e.nbr));
                }
            }
        }
    }

    static class Pair1 {
        int prev;
        int curr;

        public Pair1(int prev, int curr) {
            this.prev = prev;
            this.curr = curr;
        }
    }

    private static void BFSMarkingParent(ArrayList<Edge>[] graph, int src, int[] parent) {
        Queue<Pair1> q = new LinkedList<>();
        q.add(new Pair1(src, src));
        parent[src] = src;
        while (q.size() > 0) {

            Pair1 prevPair = q.remove();

            for (Edge e : graph[prevPair.curr]) {

                if (parent[e.nbr] == -1) {
                    parent[e.nbr] = prevPair.curr;
                    q.add(new Pair1(prevPair.curr, e.nbr));
                }
            }
        }
        for (int i = 0; i < graph.length; i++) {
            System.out.print(parent[i] + " ");
        }
        System.out.println();
    }

    private static void BFSMarkingParent2(ArrayList<Edge>[] graph, int src, int[] parent) {
        Queue<Pair1> q = new LinkedList<>();
        q.add(new Pair1(src, src));
        while (!q.isEmpty()) {
            Pair1 p = q.poll();
            int v = p.curr;

            if (parent[v] == -1 || parent[v] == v) {
                // only process unvisited vertices
                parent[v] = p.prev;

                for (Edge e : graph[v]) {
                    if (parent[e.nbr] == -1) {
                        //System.out.println(e.nbr);
                        q.add(new Pair1(v, e.nbr));
                    }
                }
            }
        }
        for (int i = 0; i < graph.length; i++) {
            System.out.print(parent[i] + " ");
        }
        System.out.println();
    }
}

/*

int[] parent = new int[n];
        Arrays.fill(parent, -1);

        Queue<Pair<Integer, Integer>> bag = new LinkedList<>();
        bag.add(new Pair<Integer, Integer>(-1, s));

        while (!bag.isEmpty()) {
            Pair<Integer, Integer> p = bag.poll();
            int v = p.getValue();

            if (parent[v] == -1) {
                // only process unvisited vertices
                parent[v] = p.getKey();

                for (int w : adjList.get(v)) {
                    if (parent[w] == -1) {
                        // only add unvisited neighbors to the bag
                        bag.add(new Pair<Integer, Integer>(v, w));
                    }
                }
            }
        }

        // print parent array
        for (int i = 0; i < n; i++) {
            System.out.print(parent[i] + " ");
        }

        System.out.println();
 */

/*

7
8
0 1
1 2
2 3
0 3
3 4
4 5
5 6
4 6
2
 */