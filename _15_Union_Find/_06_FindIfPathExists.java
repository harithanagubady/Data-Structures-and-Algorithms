import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
https://leetcode.com/problems/find-if-path-exists-in-graph/description/
 */

//Time Complexity = O(ElogV)
public class _06_FindIfPathExists {
    public static boolean validPath(int n, int[][] edges, int source, int destination) {
        _03_UnionByRankAndPathCompression uf = new _03_UnionByRankAndPathCompression(n);

        for (int[] e : edges) {
            uf.union(e[0], e[1]);
        }
        return uf.find(source) == uf.find(destination);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int e = Integer.parseInt(br.readLine());
        int[][] edges = new int[e][2];
        for (int i = 0; i < e; i++) {
            String line = br.readLine();
            String[] words = line.split(" ");
            edges[i][0] = Integer.parseInt(words[0]);
            edges[i][1] = Integer.parseInt(words[1]);
        }
        int source = Integer.parseInt(br.readLine());
        int destination = Integer.parseInt(br.readLine());
        System.out.println(validPath(n, edges, source, destination));
    }
}
