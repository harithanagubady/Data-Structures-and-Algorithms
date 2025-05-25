import java.util.Map;
import java.util.TreeMap;

public class _31_LC1094_CarPooling {

    public static void main(String[] args) {
        int[][] trips = {{2, 1, 5}, {3, 3, 7}};
        int capacity = 4;
        System.out.println(carPooling(trips, capacity));
        capacity = 5;
        System.out.println(carPooling2(trips, capacity));
    }

    public static boolean carPooling(int[][] trips, int capacity) {

        int[] arr = new int[1001];
        for (int[] trip : trips) {
            arr[trip[1]] += trip[0];
            arr[trip[2]] -= trip[0];
        }

        for (int i = 0; capacity >= 0 && i < 1001; i++) {
            capacity -= arr[i];
        }

        return capacity >= 0;
    }

    //similar to LC253 meeting rooms 2
    public static boolean carPooling2(int[][] trips, int capacity) {
        Map<Integer, Integer> m = new TreeMap<>();
        for (int[] t : trips) {
            m.put(t[1], m.getOrDefault(t[1], 0) + t[0]);
            m.put(t[2], m.getOrDefault(t[2], 0) - t[0]);
        }
        for (int v : m.values()) {
            capacity -= v;
            if (capacity < 0) {
                return false;
            }
        }
        return true;
    }
}
