import java.util.Arrays;

/*
https://leetcode.com/problems/apple-redistribution-into-boxes/description/
 */
public class _01_LC3074__AppleRedistribution {

    public static void main(String[] args) {
        int[] apples = {1, 3, 2};
        int[] capacities = {4, 3, 1, 5, 2};

        System.out.println(minimumBoxes(apples, capacities));
    }

    public static int minimumBoxes(int[] apple, int[] capacity) {
        Arrays.sort(capacity);
        int sum = Arrays.stream(apple).sum();
        int n = capacity.length - 1;
        int minBoxes = 0;
        while (n >= 0) {
            sum -= capacity[n];
            minBoxes++;
            if (sum <= 0) break;
            n--;
        }
        return minBoxes;
    }
}
