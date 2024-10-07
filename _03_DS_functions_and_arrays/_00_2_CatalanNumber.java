/*
https://www.geeksforgeeks.org/program-nth-catalan-number/
 */
public class _00_2_CatalanNumber {

    public static void main(String[] args) {
        System.out.println(findCatalanNumberNaiveApproach (3));
        System.out.println(findCatalanNumberRecursion (3));
        System.out.println(findCatalanNumberDP (3));
        System.out.println(findCatalanBinomialCoefficient (3));
    }

    private static int findCatalanNumberNaiveApproach(int n) {
        if (n <= 1) {
            return 1;
        }
        return (int)(((double)(4 * n - 2) / (double)(n + 1)) * findCatalanNumberNaiveApproach(n - 1));
    }

    public static int findCatalanNumberRecursion (int n) {
        if (n <= 1) {
            return 1;
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            res += findCatalanNumberRecursion(i) * findCatalanNumberRecursion(n - i - 1);
        }
        return res;
    }

    public static int findCatalanNumberDP (int n) {
        int[] catalan = new int[n + 1];
        catalan[0] = catalan[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                catalan[i] += catalan[j] * catalan[i - j - 1];
            }
        }
        return catalan[n];
    }

    public static int findCatalanBinomialCoefficient(int n) {
        int res = _00_3_BinomialCoefficient.binomialCoefficientWithPascalTriangle(2*n, n);
        return res/(n + 1);
    }
}
