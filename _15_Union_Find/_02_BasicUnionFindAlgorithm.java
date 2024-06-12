public class _02_BasicUnionFindAlgorithm {

    public int[] parent;
    public int N;

    public _02_BasicUnionFindAlgorithm(int size) {
        this.N = size;
        parent = new int[N];
        for (int i = 0; i < N; i++) {
            parent[i] = i;
        }
    }

    public int find(int i) {
        if (parent[i] == i) {
            return i;
        }
        return find(parent[i]);
    }

    public void union(int u, int v) {
        int urep = find(u);
        int vrep = find(v);
        parent[vrep] = urep;
    }

    public static void main(String[] args) {
        _02_BasicUnionFindAlgorithm s = new _02_BasicUnionFindAlgorithm(5);
        s.union(0, 1);
        s.union(2, 3);
        s.union(4, 2);

        if (s.find(0) == s.find(3)) {
            System.out.println("same set");
        } else {
            System.out.println("no");
        }
    }
}
