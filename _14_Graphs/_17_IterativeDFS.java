import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

//Print All Paths in Iterative DFS Approach
public class _17_IterativeDFS {

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

        List<LinkedList<Integer>> allPaths = iterativeDFS(graph, src, dest);
        for (LinkedList<Integer> ll : allPaths) {
            for (int i : ll) {
                System.out.print(i);
            }
            System.out.println();
        }
    }

    static class Pair {

        int v;
        LinkedList<Integer> psf;

        boolean[] visited;

        public Pair (int v, LinkedList<Integer> psf, boolean[] visited) {
            this.v = v;
            this.psf = psf;
            this.visited = visited;
        }
    }
    private static List<LinkedList<Integer>> iterativeDFS(ArrayList<Edge>[] graph, int src, int desc) {

        Stack<Pair> st = new Stack<>();
        List<LinkedList<Integer>> allLists = new ArrayList<>();
        LinkedList<Integer> initialPath = new LinkedList<>();
        initialPath.add(src);
        st.push(new Pair(src, initialPath, new boolean[graph.length]));

        while (st.size() > 0) {

            Pair rem = st.pop();
            if (rem.visited[rem.v]) {
                continue;
            }
            rem.visited[rem.v] = true;
            if (rem.v == desc) {
                allLists.add(rem.psf);
                continue;
            }
            for (Edge e : graph[rem.v]) {
                if (!rem.visited[e.nbr]) {
                    LinkedList<Integer> ll = new LinkedList<>(rem.psf);
                    ll.add(e.nbr);
                    st.push(new Pair(e.nbr, ll, Arrays.copyOf(rem.visited, graph.length)));
                }
            }
        }
        return allLists;
    }
}

/*

7
8
0 1 10
1 2 10
2 3 10
0 3 31
3 4 2
4 5 3
5 6 3
4 6 3
0
6

 */