import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
https://leetcode.com/problems/all-paths-from-source-to-target/description/
 */
public class _02_PrintAllPaths {

    static class Edge {
        int src;
        int nbr;

        Edge(int src, int nbr) {
            this.src = src;
            this.nbr = nbr;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int vtces = Integer.parseInt(br.readLine());
        ArrayList<Edge>[] graph = new ArrayList[vtces];
        for (int i = 0; i < vtces; i++) {
            graph[i] = new ArrayList<>();
        }

        int edges = Integer.parseInt(br.readLine());
        for (int i = 0; i < edges; i++) {
            String[] parts = br.readLine().split(" ");
            int v1 = Integer.parseInt(parts[0]);
            int v2 = Integer.parseInt(parts[1]);
            graph[v1].add(new Edge(v1, v2));
            graph[v2].add(new Edge(v2, v1));
        }

        int src = Integer.parseInt(br.readLine());
        int dest = Integer.parseInt(br.readLine());

        // write all your codes here

        String s = "";
        boolean[] visited = new boolean[vtces];
        List<LinkedList<Integer>> res = findAllPaths(graph, src, dest, visited);
        for (LinkedList<Integer> l : res) {
            for (int i : l) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    private static List<LinkedList<Integer>> findAllPaths(ArrayList<Edge>[] graph, int src, int dest, boolean[] visited) {

        List<LinkedList<Integer>> currPaths = new ArrayList<>();
        if (src == dest) {
            LinkedList<Integer> path = new LinkedList<>();
            path.add(src);
            currPaths.add(path);
            return currPaths;
        }

        for (Edge e : graph[src]) {
            if (!visited[e.nbr]) {
                visited[src] = true;
                List<LinkedList<Integer>> nbrPaths = findAllPaths(graph, e.nbr, dest, visited);
                for (LinkedList<Integer> nbrPath : nbrPaths) {
                    nbrPath.addFirst(src);
                    currPaths.add(nbrPath);
                }
                visited[src] = false;
            }
        }

        return currPaths;
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
0
6
 */