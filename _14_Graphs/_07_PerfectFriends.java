import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*

You are given a number n (representing the number of students).
Each student will have an id from 0 to n - 1
In the next k lines, two numbers are given separated by a space.
The numbers are ids of students belonging to same club
You have to find in how many ways can we select a pair of students such that both students are from different clubs.
 */
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

        //l1
        //l2
        //l3
        //l1*l2 + l1*l3 + l2*l3
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
/*

7
5
0 1
2 3
4 5
5 6
4 6
 */