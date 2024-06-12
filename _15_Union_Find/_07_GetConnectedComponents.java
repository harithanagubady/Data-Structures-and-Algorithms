import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
7
5
0 1
2 3
4 5
5 6
4 6

o/p: 0 1, 2 3, 4 5 6
 */
public class _07_GetConnectedComponents {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int v = Integer.parseInt(bf.readLine());
        int e = Integer.parseInt(bf.readLine());

        int[][] edges = new int[e][2];

        for (int i = 0; i < e; i++) {
            String[] s = bf.readLine().split(" ");
            int v1 = Integer.parseInt(s[0]);
            int v2 = Integer.parseInt(s[1]);
            edges[i][0] = v1;
            edges[i][1] = v2;
        }

        List<List<Integer>> l = new _07_GetConnectedComponents().getConnectedComponents(v, edges);
        for (List<Integer> cc : l) {
            for (int i : cc) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    public List<List<Integer>> getConnectedComponents(int n, int[][] edges) {
        int[] parent = new int[n];
        //Initially all vertices are independent sets. CountOfSets = CountOfVertices
        //When there is an edge between them, we perform union
        //Every time we union 2 vertices, the set count decreases

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        for (int[] i : edges) {
            int uref = find(parent, i[0]);
            int vref = find(parent, i[1]);
            if (uref != vref) {
                union(parent, uref, vref);
            }
        }

        return findUnconnectedGraphs(parent);
    }

    public int find(int[] parent, int i) {
        int j = i;
        while (parent[i] != i) {
            i = parent[i];
        }
        parent[j] = i;
        return i;
    }

    public void union(int[] parent, int u, int v) {
        parent[u] = v;
    }

    public List<List<Integer>> findUnconnectedGraphs(int[] parent) {
        Map<Integer, List<Integer>> ll = new HashMap<>();
        for (int i = 0; i < parent.length; i++) {
            int rep = parent[i];
            if (!ll.containsKey(rep)) {
                List<Integer> l = new ArrayList<>();
                ll.put(rep, l);
            }
            ll.get(rep).add(i);
        }

        return new ArrayList<>(ll.values());
    }

}
