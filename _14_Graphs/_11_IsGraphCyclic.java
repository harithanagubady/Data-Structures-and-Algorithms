import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class _11_IsGraphCyclic {

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
        boolean[] visited = new boolean[v];
        boolean isCyclic = false;
        for (int i = 0; i < v; i++) {
            if(!visited[i]) {
                isCyclic = BFS(graph, i, visited);
                //isCyclic = DFS(graph, i, visited, -1);
            }
            if (isCyclic) break;
        }
        System.out.println(isCyclic);
    }

    static class Pair {
        int e;
        String psf;

        public Pair(int e, String psf) {
            this.e = e;
            this.psf = psf;
        }
    }

    private static boolean BFS(ArrayList<Edge>[] graph, int i, boolean[] visited) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(i, "" + i));
        while (q.size() > 0) {

            Pair prevPair = q.remove();

            System.out.println(prevPair.e);
            if (visited[prevPair.e]) {
                return true;
            }
            visited[prevPair.e] = true;
            //System.out.println(prevPair.e + "@" + prevPair.psf);
            for (Edge e : graph[prevPair.e]) {
                if (!visited[e.nbr]) {
                    q.add(new Pair(e.nbr, prevPair.psf + e.nbr));
                }
            }
        }
        return false;
    }

    private static boolean DFS(ArrayList<Edge>[] graph, int src, boolean[] visited, int lastVisited) {
        visited[src] = true;
        for (Edge e : graph[src]) {
            if (lastVisited != e.nbr && visited[e.nbr]) {
                return true;
            }
            if (!visited[e.nbr]) {
                DFS(graph, e.nbr, visited, src);
            }
        }
        visited[src] = false;
        return false;
    }
}

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




7
4
0 1
3 2
4 5
6 5
 */