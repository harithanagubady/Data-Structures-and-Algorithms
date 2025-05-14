import java.util.Random;
import java.util.TreeMap;

public class _25_LC528_RandomPickWithWeight {

    int n;
    Random random;
    TreeMap<Integer, Integer> map;
    int sum = 0;

    public _25_LC528_RandomPickWithWeight(int[] w) {
        n = w.length;
        map = new TreeMap<>();
        random = new Random();
        for (int i = 0; i < n; i++) {
            sum += w[i];
            map.put(sum, i);
        }
    }

    public int pickIndex() {
        int key = map.higherKey(random.nextInt(sum));
        return map.get(key);
    }

    public static void main(String[] args) {
        int[] arr = {1, 3};
        _25_LC528_RandomPickWithWeight obj = new _25_LC528_RandomPickWithWeight(arr);
        System.out.println(obj.pickIndex());
        System.out.println(obj.pickIndex());
        System.out.println(obj.pickIndex());
        System.out.println(obj.pickIndex());
        System.out.println(obj.pickIndex());
    }
}
