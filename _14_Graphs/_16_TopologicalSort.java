import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class _16_TopologicalSort {

    public static class Edge {
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
        }

        boolean[] visited = new boolean[v];
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < v; i++) {
            if (!visited[i])
                topologicalSort(graph, i, visited, st);
        }
        while (st.size() > 0) {
            System.out.println(st.pop());
        }
    }

    private static void topologicalSort(ArrayList<Edge>[] graph, int src, boolean[] visited, Stack<Integer> st) {
        visited[src] = true;
        for (Edge e : graph[src]) {
            if (!visited[e.nbr]) {
                topologicalSort(graph, e.nbr, visited, st);
            }
        }
        st.push(src);
    }
}


/*

7
8
0 3
0 1
1 2
2 3
4 3
4 5
5 6
4 6
 */