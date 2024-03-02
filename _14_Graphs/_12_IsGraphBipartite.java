import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class _12_IsGraphBipartite {

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

        int[] visited = new int[v];
        Arrays.fill(visited, -1);
        boolean isBipartite;
        for (int i = 0; i < v; i++) {
            if(visited[i] == -1) {
                isBipartite = isBipartite(graph, i, visited);
                if (!isBipartite) {
                    System.out.println(false);
                    return;
                }
            }
        }
        System.out.println(true);
    }

    private static boolean isBipartite(ArrayList<Edge>[] graph, int i, int[] visited) {

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(i, 0));

        while(q.size() > 0) {
            Pair rem = q.remove();
            if (visited[rem.v] != -1) {
                if (rem.level != visited[rem.v]) {
                    return false;
                }
            } else {
                visited[rem.v] = rem.level;
            }
            for (Edge e : graph[rem.v]) {
                if (visited[e.nbr] == -1) {
                    q.add(new Pair(e.nbr, rem.level + 1));
                }
            }
        }

        return true;
    }

    static class Pair {
        int v;
        int level;

        public Pair (int v, int level) {
            this.v = v;
            this.level = level;
        }
    }


}

/*

5
5
0 1
1 3
3 4
2 0
2 4



6
6
0 1
5 0
4 5
3 4
2 3
1 2

 */