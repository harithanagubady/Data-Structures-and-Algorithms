import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class _05_IsGraphConnected {


    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int v = Integer.parseInt(bf.readLine());
        int e = Integer.parseInt(bf.readLine());

        ArrayList<_04_ConnectedComponents.Edge>[] graph = new ArrayList[v];
        for (int i = 0; i < v; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < e; i++) {
            String[] s = bf.readLine().split(" ");
            int v1 = Integer.parseInt(s[0]);
            int v2 = Integer.parseInt(s[1]);
            int wt = Integer.parseInt(s[2]);
            graph[v1].add(new _04_ConnectedComponents.Edge(v1, v2, wt));
            graph[v2].add(new _04_ConnectedComponents.Edge(v2, v1, wt));
        }

        LinkedList<Integer> ans;
        List<LinkedList<Integer>> res = new ArrayList<>();
        boolean[] visited = new boolean[v];
        for (int i = 0; i < v; i++) {
            if (!visited[i]) {
                ans = _04_ConnectedComponents.findConnectedComponents(graph, i, visited, new LinkedList<>());
                res.add(ans); // adding linked list to another list. Alternative: you can print the linked list here directly...
            }
        }
        System.out.println(isConnected(res));
    }

    private static boolean isConnected(List<LinkedList<Integer>> res) {
        return res.size() == 1;
    }
}

/*

7
8
0 1 10
1 2 10
2 3 10
0 3 10
3 4 10
4 5 10
5 6 10
4 6 10
 */


/*
7
5
0 1 10
2 3 10
4 5 10
5 6 10
4 6 10


 */
