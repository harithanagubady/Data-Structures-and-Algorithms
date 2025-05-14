public class _27_LC2222_NumOfWaysToSelectBuildings {

    public static void main(String[] args) {
        String s = "001101";
        System.out.println(numberOfWays(s));
    }

    public static long numberOfWays(String s) {
        long totalZeroes = 0;

        for (char ch : s.toCharArray()) {
            if (ch == '0') totalZeroes++;
        }

        int n = s.length();
        long totalOnes = n - totalZeroes;
        long currZeroes = 0, currOnes = 0;

        long res = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '0') {
                res += currOnes * (totalOnes - currOnes);
                currZeroes++;
            } else {
                res += currZeroes * (totalZeroes - currZeroes);
                currOnes++;
            }
        }

        return res;
    }
}
