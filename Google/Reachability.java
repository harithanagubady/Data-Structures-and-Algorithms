import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Reachability {

    static class UnionFind {

        public int[] parent;
        int noOfUnions;
        public UnionFind(int size) {
            parent = new int[size];
            for (int i = 0; i < size; i++) {
                parent[i] = i;
            }
            noOfUnions = 0;
        }

        public int find(int i) {
            if (parent[i] == i) {
                return i;
            }
            parent[i] = find(parent[i]); //path compression or collapsing find
            return parent[i];
        }

        public int union (int u, int v) {
            System.out.println("Union called on edge: " + u + " -> " + v);
            int urep = find(u);
            int vrep = find(v);

            parent[urep] = vrep;
            noOfUnions++;

            return noOfUnions;
        }
    }

    public static int checkReachability (int v, int[][] connections) {

        UnionFind uf = new UnionFind(v);
        for (int[] connection : connections) {
            int src = connection[0];
            int dest = connection[1];
            int u = uf.find(src);
            int w = uf.find(dest);
            if (u != w) {
                int count = uf.union(src, dest);
                if (count == v - 1) {
                    return connection[2];
                }
            }
        }

        return 0;
    }

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

        int e = Integer.parseInt(bf.readLine());
        int[][] connections = new int[e][3];
        for (int i = 0; i < e; i++) {
            String[] s = bf.readLine().split(" ");
            int v1 = Integer.parseInt(s[0]);
            int v2 = Integer.parseInt(s[1]);
            int wt = Integer.parseInt(s[2]);
            connections[i] = new int[]{v1, v2, wt};
        }
        System.out.println(checkReachability(v, connections));
    }


}
