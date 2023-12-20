import java.util.ArrayList;
import java.util.List;

public class Main {


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
    public static void main(String[] args) {
        int vrtcs = 7;
        ArrayList<Edge>[] graph = new ArrayList[vrtcs];
        for (int i = 0; i< vrtcs; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0, 1, 10));
        graph[0].add(new Edge(0, 3, 10));
        graph[1].add(new Edge(1, 0, 10));
        graph[1].add(new Edge(1, 2, 10));
        graph[2].add(new Edge(2, 1, 10));
        graph[2].add(new Edge(2, 3, 10));
        graph[3].add(new Edge(3, 0, 40));
        graph[3].add(new Edge(3, 2, 10));
        graph[3].add(new Edge(3, 4, 2));
        graph[4].add(new Edge(4, 5, 3));
        graph[4].add(new Edge(4, 3, 2));
        graph[4].add(new Edge(4, 6, 3));
        graph[5].add(new Edge(5, 4, 3));
        graph[5].add(new Edge(5, 6, 3));
        graph[6].add(new Edge(6, 5, 3));
        graph[6].add(new Edge(6, 4, 3));
    }
}

