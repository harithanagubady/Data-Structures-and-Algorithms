import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _08_HamiltonianPathAndCycle {

    static class Edge {
        int src;
        int nbr;

        public Edge(int src, int nbr) {
            this.src = src;
            this.nbr = nbr;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int v = Integer.parseInt(br.readLine());
        ArrayList<Edge>[] graph = new ArrayList[v];
        for (int i = 0; i < v; i++) {
            graph[i] = new ArrayList<>();
        }
        int e = Integer.parseInt(br.readLine());
        for (int i = 0; i < e; i++) {
            String[] s = br.readLine().split(" ");
            int v1 = Integer.parseInt(s[0]);
            int v2 = Integer.parseInt(s[1]);
            graph[v1].add(new Edge(v1, v2));
            graph[v2].add(new Edge(v2, v1));
        }
        int src = Integer.parseInt(br.readLine());
        LinkedHashSet<Integer> visited = new LinkedHashSet<>();
        List<String> ans = getHamiltonianPaths(graph, src, visited, "" + src, src);
        System.out.println(ans);
    }

    private static List<String> getHamiltonianPaths(ArrayList<Edge>[] graph, int src, LinkedHashSet<Integer> visited, String psf, int osrc) {
        if (visited.size() == graph.length - 1) {

            boolean isStar = false;
            for (Edge e : graph[src]) {
                if (e.nbr == osrc) {
                    isStar = true;
                    break;
                }
            }
            if (isStar) {
                psf += " *";
            } else {
                psf += " .";
            }
            List<String> newList = new ArrayList<>();
            newList.add(psf);
            return newList;
        }
        visited.add(src);
        List<String> ans = new ArrayList<>();
        for (Edge e : graph[src]) {
            if (!visited.contains(e.nbr)) {
                List<String> list = getHamiltonianPaths(graph, e.nbr, visited, psf + " " + e.nbr, osrc);
                ans.addAll(list);
            }
        }
        visited.remove(src);
        return ans;
    }
}

/*

7
9
0 1
1 2
2 3
2 5
0 3
3 4
4 5
5 6
4 6
0
 */