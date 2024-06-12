import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class _01_DetectCycleUsingUnionFind {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int v = Integer.parseInt(bf.readLine());
        ArrayList<Edge>[] graph = new ArrayList[v];
        for (int i = 0; i < v; i++) {
            graph[i] = new ArrayList<>();
        }

        int e = Integer.parseInt(bf.readLine());
        List<Edge> graphEdges = new ArrayList<>();
        for (int i = 0; i < e; i++) {
            String[] s = bf.readLine().split(" ");
            int v1 = Integer.parseInt(s[0]);
            int v2 = Integer.parseInt(s[1]);
            int wt = Integer.parseInt(s[2]);
            graph[v1].add(new Edge(v1, v2, wt));
            graph[v2].add(new Edge(v2, v1, wt));
            graphEdges.add(new Edge(v1, v2, wt));
        }

        boolean res = detectCycleUsingUnionFind(graphEdges, v);
        System.out.println(res ? "Cycle detected" : "No Cycle detected");
    }


    private static boolean detectCycleUsingUnionFind(List<Edge> graphEdges, int noOfVertices) {
        Collections.sort(graphEdges);
        UnionFind uf = new UnionFind(noOfVertices);
        for (Edge e : graphEdges) {
            if (uf.find(e.src) == uf.find(e.nbr)) {
                return true;
            }
            uf.union(e.src, e.nbr);
        }
        return false;
    }

    static class UnionFind {

        public int[] parent;
        public UnionFind(int size) {
            parent = new int[size];
            for (int i = 0; i < size; i++) {
                parent[i] = i;
            }
        }

        public int find(int i) {
            if (parent[i] == i) {
                return i;
            }
            parent[i] = find(parent[i]); //path compression or collapsing find
            return parent[i];
        }

        public void union (int u, int v) {
            int urep = find(u);
            int vrep = find(v);
            if (urep != vrep) {
                parent[urep] = vrep;
            }
        }
    }

    public static class Edge implements Comparable<Edge>{
        int src;
        int nbr;
        int wt;

        public Edge(int src, int nbr, int wt) {
            this.src = src;
            this.nbr = nbr;
            this.wt = wt;
        }

        @Override
        public int compareTo(Edge o) {
            return this.wt - o.wt;
        }
    }

}


/*
8
8
0 2 7
0 1 1
1 3 5
4 1 6
5 7 8
4 5 3
6 4 9
6 7 4

3 2 2

 */