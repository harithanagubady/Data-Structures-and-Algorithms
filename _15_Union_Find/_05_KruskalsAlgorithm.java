import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//Uses Greedy Approach
//Uses Union Find to Detect Cycle
//Used to find MST of a Graph (even unconnected)
//Minimum timestamp at which all friends are reachable <=> MST using Kruskal algorithm
public class _05_KruskalsAlgorithm {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int noOfFriends = Integer.parseInt(br.readLine());
        int noOfConnections = Integer.parseInt(br.readLine());
        List<Edge<String, String, Integer>> connections = new ArrayList<>();
        for (int i = 0; i < noOfConnections; i++) {
            String line = br.readLine();
            String[] words = line.split(" ");
            connections.add(new Edge<>(words[0], words[1], Integer.parseInt(words[2])));
        }
        connections.sort(Comparator.comparingInt(e -> e.wt));
        int[] resultingEdges = kruskalAlgorithm(noOfFriends, connections);
        for (int i : resultingEdges) {
            System.out.println(i);
        }
    }

    public static int[] kruskalAlgorithm (int noOfFriends, List<Edge<String, String, Integer>> connections) {
        int noOfEdges = 0, j = 0;
        _03_UnionByRankAndPathCompression uf = new _03_UnionByRankAndPathCompression(noOfFriends);
        HashMap<String, Integer> hm = new HashMap<>();
        int i = 0;
        int[] result = new int[noOfFriends];
        while (noOfEdges < noOfFriends - 1) {
            Edge<String, String, Integer> e = connections.get(j);
            if (!hm.containsKey(e.src)) {
                hm.put(e.src, i);
                i++;
            }

            if (!hm.containsKey(e.nbr)) {
                hm.put(e.nbr, i);
                i++;
            }

            int urep = uf.find(hm.get(e.src));
            int vrep = uf.find(hm.get(e.nbr));

            if (urep != vrep) {
                result[noOfEdges++] = e.wt;
                uf.unionByRank(urep, vrep);
            }
            j++;
        }
        return result;
    }

    static class Edge<T, U, W>  {
        T src;
        U nbr;
        W wt;

        public Edge (T t, U u, W w) {
            this.src = t;
            this.nbr = u;
            this.wt = w;
        }
    }
}


/*
5
6
Alice Bob 5
Bob Candie 6
Candie Dolly 1
Alice Ellie 4
Alice Dolly 3
Dolly Ellie 2
 */

/*

 c - d - e
     |
     a - b
 */