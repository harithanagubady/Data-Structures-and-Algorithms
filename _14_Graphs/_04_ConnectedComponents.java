import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class _04_ConnectedComponents {

    static class Edge {
        int src;
        int nbr;
        int wt;

        public Edge(int src, int nbr, int wt) {
            this.src = src;
            this.nbr = nbr;
            this.wt = wt;
        }
    }

    static int v;

    public static void main(String[] args) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        int vertices = Integer.parseInt(bfr.readLine());
        ArrayList<Edge>[] graph = new ArrayList[vertices];
        for (int i = 0; i < vertices; i++) {
            graph[i] = new ArrayList<>();
        }
        int edges = Integer.parseInt(bfr.readLine());
        for (int i = 0; i < edges; i++) {
            String[] s = bfr.readLine().split(" ");
            int v1 = Integer.parseInt(s[0]);
            int v2 = Integer.parseInt(s[1]);
            int w = Integer.parseInt(s[2]);
            graph[v1].add(new Edge(v1, v2, w));
            graph[v2].add(new Edge(v2, v1, w));
        }

        LinkedList<Integer> ans;
        boolean[] visited = new boolean[vertices];
        List<LinkedList<Integer>> res = new ArrayList<>();
        for (int i = 0; i < vertices; i++) {
            if(!visited[i]) {
                ans = findConnectedComponents(graph, i, visited, new LinkedList<>());
                res.add(ans); // adding linked list to another list. Alternative: you can print the linked list here directly...
            }

        }
        for (LinkedList<Integer> ll : res) {
            for (int i : ll) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    public static LinkedList<Integer> findConnectedComponents(ArrayList<Edge>[] graph, int src, boolean[] visited, LinkedList<Integer> lsf) {

        lsf.add(src);
        visited[src] = true;
        for (Edge e : graph[src]) {
            if (!visited[e.nbr]) {
                findConnectedComponents(graph, e.nbr, visited, lsf);
            }
        }
        return lsf;
    }
}
