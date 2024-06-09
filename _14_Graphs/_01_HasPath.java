import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;


//DFS Algorithm
/*
Leetcode https://leetcode.com/problems/find-if-path-exists-in-graph/description/
 */
public class _01_HasPath {

    static class Edge {
        int src;
        int nbr;
        int wt;

        Edge(int src, int nbr, int wt) {
            this.src = src;
            this.nbr = nbr;
            this.wt = wt;
        }
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int vertices = Integer.parseInt(br.readLine());
        ArrayList<Edge>[] graph = new ArrayList[vertices];
        for (int i = 0; i < vertices; i++) {
            graph[i] = new ArrayList<>();
        }

        int edges = Integer.parseInt(br.readLine());
        for (int i = 0; i < edges; i++) {
            String s = br.readLine();
            String[] sa = s.split(" ");
            int src = Integer.parseInt(sa[0]);
            int dest = Integer.parseInt(sa[1]);
            int wt = Integer.parseInt(sa[2]);
            graph[src].add(new Edge(src, dest, wt));
            graph[dest].add(new Edge(dest, src, wt));
        }

        int src = Integer.parseInt(br.readLine());
        int dest = Integer.parseInt(br.readLine());

        boolean[] visited = new boolean[vertices];
        System.out.println(hasPath(graph, src, dest, visited));
    }

    private static boolean hasPath(ArrayList<Edge>[] graph, int src, int dest, boolean[] visited) {

        if (src == dest) {
            return true;
        }

        visited[src] = true;

        for (Edge e : graph[src]) {
            System.out.println(src + " - " + e.nbr);
            if (!visited[e.nbr]) {
                if(hasPath(graph, e.nbr, dest, visited)) {
                    return true;
                }
            }
        }
        //visited[src] = false;
        return false;
    }
}




/*
5
5
0 1 10
1 2 10
2 3 10
2 4 20
4 1 10
1
4
 */










/*

if (src == desc) return true;
        visited[src] = true;
        for (Edge e : graph[src]) {
            System.out.println(e.src + " " + e.nbr);
            if (!visited[e.nbr])
                return hasPath(graph, e.nbr, desc, visited);
        }
        visited[src] = false;
        return false;
 */