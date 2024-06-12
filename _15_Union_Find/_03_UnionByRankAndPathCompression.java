public class _03_UnionByRankAndPathCompression {

    public int[] parent;
    public int N;

    public int[] rank;

    public _03_UnionByRankAndPathCompression(int size) {
        this.N = size;
        parent = new int[N];
        rank = new int[N];
        for (int i = 0; i < N; i++) {
            parent[i] = i;
        }
    }

    public int find(int i) {
        if (parent[i] == i) {
            return i;
        }
        return parent[i] = find(parent[i]);
    }

    public void union(int u, int v) {
        int urep = find(u);
        int vrep = find(v);
        parent[vrep] = urep;
    }

    public void unionByRank(int u, int v) {
        int urep = find(u);
        int vrep = find(v);
        if (urep == vrep) {
            return;
        }
        if (rank[urep] > rank[vrep]) {
            parent[vrep] = urep;
        } else if (rank[urep] < rank[vrep]) {
            parent[urep] = vrep;
        } else {
            rank[urep]++;
            parent[vrep] = urep;
        }
    }

    public static void main(String[] args) {
        _03_UnionByRankAndPathCompression s = new _03_UnionByRankAndPathCompression(5);
        s.unionByRank(0, 1);
        s.unionByRank(2, 3);
        s.unionByRank(4, 2);

        if (s.find(0) == s.find(3)) {
            System.out.println("same set");
        } else {
            System.out.println("no");
        }
    }
}
