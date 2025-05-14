public class _23_LC1893_CheckIfAllIntegersInRangeAreCovered {

    public static void main(String[] args) {

        int[][] ranges = {{1, 2}, {3, 4}, {5, 6}};
        int left = 2, right = 5;
        System.out.println(isCovered(ranges, left, right));
    }

    public static boolean isCovered(int[][] ranges, int left, int right) {

        int[] p = new int[52];

        for (int[] range : ranges) {
            p[range[0]]++;
            p[range[1] + 1]--;
        }

        for (int i = 1; i < p.length; i++) {
            p[i] += p[i - 1];
            if (i >= left && i <= right) {
                if (p[i] == 0) return false;
            }
        }

        return true;
    }
}
