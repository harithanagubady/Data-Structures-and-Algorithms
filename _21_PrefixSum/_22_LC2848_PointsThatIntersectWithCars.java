import java.util.ArrayList;
import java.util.List;

public class _22_LC2848_PointsThatIntersectWithCars {

    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<>();
        list.add(List.of(3, 6));
        list.add(List.of(1, 5));
        list.add(List.of(4, 7));
        System.out.println(numberOfPoints(list));
    }

    public static int numberOfPoints(List<List<Integer>> nums) {
        int[] p = new int[102];

        for (List<Integer> l : nums) {
            p[l.get(0)]++;
            p[l.get(1) + 1]--;
        }

        int ans = 0;
        for (int i = 1; i < p.length; i++) {
            p[i] += p[i - 1];
            if(p[i] != 0) ans++;
        }

        return ans;
    }
}
