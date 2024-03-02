import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class _13_SpreadOfInfection {

    public static class Edge {
        int src;
        int nbr;
        public Edge (int src, int nbr) {
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

        int src = Integer.parseInt(bf.readLine());
        int t = Integer.parseInt(bf.readLine());

        boolean[] visited = new boolean[v];
        int count = spreadOfInfection (graph, src, t, visited);
        System.out.println(count);
    }

    private static int spreadOfInfection(ArrayList<Edge>[] graph, int src, int t, boolean[] visited) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(src, 1));

        int count = 0;
        while (q.size() > 0) {
            Pair rem = q.remove();

            if (visited[rem.v]) {
                continue;
            }

            visited[rem.v] = true;

            if (rem.time > t) {
                break;
            }
            count++;

            for (Edge e : graph[rem.v]) {
                if (!visited[e.nbr]) {
                    q.add(new Pair(e.nbr, rem.time + 1));
                }
            }
        }

        return count;
    }

    public static class Pair {

        int v;
        int time;

        public Pair(int v, int time) {
            this.v = v;
            this.time = time;
        }
    }
}
