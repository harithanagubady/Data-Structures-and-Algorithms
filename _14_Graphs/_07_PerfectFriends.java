import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class _07_PerfectFriends {

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
        int noOfStudents = Integer.parseInt(bf.readLine());
        ArrayList<Edge>[] graph = new ArrayList[noOfStudents];
        for (int i = 0; i < noOfStudents; i++) {
            graph[i] = new ArrayList<>();
        }

        int k = Integer.parseInt(bf.readLine());
        for (int i = 0; i < k; i++) {
            String[] s = bf.readLine().split(" ");
            int v1 = Integer.parseInt(s[0]);
            int v2 = Integer.parseInt(s[1]);
            graph[v1].add(new Edge(v1, v2));
            graph[v2].add(new Edge(v2, v1));
        }

        List<LinkedList<Integer>> list = new ArrayList<>();
        boolean[] visited = new boolean[noOfStudents];
        for (int i = 0; i < noOfStudents; i++) {
            if (!visited[i]) {
                LinkedList<Integer> ll = new LinkedList<>();
                getConnectedComponents(graph, i, visited, ll);
                list.add(ll);
            }
        }

        int perfectFriends = 0;
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                perfectFriends += list.get(i).size() * list.get(j).size();
            }
        }
        System.out.println(perfectFriends);
    }

    private static void getConnectedComponents(ArrayList<Edge>[] graph, int i, boolean[] visited, LinkedList<Integer> ll) {

        ll.add(i);
        visited[i] = true;
        for (Edge e : graph[i]) {
            if (!visited[e.nbr]) {
                getConnectedComponents(graph, e.nbr, visited, ll);
            }
        }
    }
}
