import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
You are given a directed acyclic graph.
You are required to print the order in which tasks could be done.
The task that should be done at last should be printed first and
the task that should be done at first should be printed last
This is called topological sort

Topological sort -> A permutation of vertices for a directed acyclic graph is called topological sort
if for all directed edges uv, u appears before v in the graph
 */
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
                topologicalSortDFS(graph, i, visited, st);
        }
        while (st.size() > 0) {
            System.out.print(st.pop() + " ");
        }
        System.out.println();
        List<Integer> l = kahnsAlgorithm(graph, 0, v);
        for (int i : l) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    private static void topologicalSortDFS(ArrayList<Edge>[] graph, int src, boolean[] visited, Stack<Integer> st) {
        //post order traversal
        visited[src] = true;
        for (Edge e : graph[src]) {
            if (!visited[e.nbr]) {
                topologicalSortDFS(graph, e.nbr, visited, st);
            }
        }
        st.push(src);
    }

    private static List<Integer> kahnsAlgorithm(ArrayList<Edge>[] graph, int src, int v) {
        Queue<Integer> zeroInDegree = new LinkedList<>();
        int[] inDegreeCount = new int[v];
        for (ArrayList<Edge> edges : graph) {
            for (Edge e : edges) {
                inDegreeCount[e.nbr]++;
            }
        }

        for (int i = 0; i < v; i++) {
            if (inDegreeCount[i] == 0) {
                zeroInDegree.add(i);
            }
        }
        List<Integer> res = new ArrayList<>();
        while (zeroInDegree.size() > 0) {
            int node = zeroInDegree.poll();
            res.add(node);
            for (Edge e : graph[node]) {
                inDegreeCount[e.nbr]--;
                if (inDegreeCount[e.nbr] == 0) {
                    zeroInDegree.add(e.nbr);
                }
            }
        }
        if (res.size() != v) {
            System.out.println("There is cycle");
            return new ArrayList<>();
        }
        return res;
    }
}


/*

5
5
0 1
1 2
2 3
3 4
4 1
 */