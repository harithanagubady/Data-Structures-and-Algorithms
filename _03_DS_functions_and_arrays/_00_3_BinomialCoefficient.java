/*
https://www.geeksforgeeks.org/binomial-coefficient-dp-9
 */
public class _00_3_BinomialCoefficient {

    public static void main(String[] args) {
        System.out.println(binomialCoefficientNaiveApproach(4, 3));
        System.out.println(binomialCoefficientWithPascalTriangle(4, 3));
        System.out.println(binomialCoefficientWithPascalTriangleDPApproach(4, 3));
        System.out.println(binomialCoefficientWithPascalTriangleOptimized(4, 3));
    }

    public static int binomialCoefficientNaiveApproach(int n, int k) {
        double prod = 1;
        for (int i = 0; i < k; i++) {
            prod *= (double) (n - i) / (double) (k - i);
        }
        return (int) prod;
    }

    public static int binomialCoefficientWithPascalTriangle(int n, int k) {
        if (k == n || k == 0) {
            return 1;
        }

        return binomialCoefficientWithPascalTriangle(n - 1, k - 1)
                + binomialCoefficientWithPascalTriangle(n - 1, k);
    }

    public static int binomialCoefficientWithPascalTriangleDPApproach(int n, int k) {

        int[][] C = new int[n + 1][k + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= Math.min(i, k); j++) {
                if (j == 0 || j == i) {
                    C[i][j] = 1;
                } else {
                    C[i][j] = C[i - 1][j - 1] + C[i - 1][j];
                }
            }
        }

        return C[n][k];
    }

    //If you only want to remember previous row to calculate next row,
    //you need not create a 2d Array which stores all rows values,
    //instead you just need a 1d Array which can be updated at each row.
    public static int binomialCoefficientWithPascalTriangleOptimized(int n, int k) {

        int[] C = new int[n + 1];
        C[0] = 1;
        for (int i = 1; i <= n; i++) {

            for (int j = Math.min(i, k); j > 0; j--) {
                C[j] = C[j - 1] + C[j];
            }
        }

        return C[k];
    }
}
