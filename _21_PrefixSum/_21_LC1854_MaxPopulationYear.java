public class _21_LC1854_MaxPopulationYear {

    public static void main(String[] args) {
        int[][] logs = {{1993, 1999}, {2000, 2010}};
        System.out.println(maximumPopulation(logs));
    }

    public static int maximumPopulation(int[][] logs) {
        int[] p = new int[101];

        for (int[] log : logs) {
            p[log[0] - 1950]++;
            p[log[1] - 1950]--;
        }

        int max = p[0], maxYear = 1950;
        for (int i = 1; i < p.length; i++) {
            p[i] += p[i - 1];
            if (max < p[i]) {
                max = p[i];
                maxYear = i + 1950;
            }
        }

        return maxYear;
    }
}
