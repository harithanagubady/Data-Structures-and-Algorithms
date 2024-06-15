public class _13_MatrixChainMultiplication {

    public static void main(String[] args) {
        int n = 5;
        int[] d = {3, 2, 4, 2, 5};
        int[][] M = new int[n][n];
        int[][] K = new int[n][n];

        //C[i,j] = i<=k<j min{C[i,k] + C[k+1,j] + d[i-1]*d[k]*d[j]}
        //A1.A2.A3.A4
        //A1.(A2.A3.A4) or (A1.A2.A3).A4 or (A1.A2).(A3.A4)
        //(A2.A3.A4) => A2.(A3.A4) or (A2.A3).A4
        for (int diff = 1; diff < n - 1; diff++) {
            for (int i = 1; i < n - diff; i++) {
                int j = i + diff;
                int min = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    int val = M[i][k] + M[k + 1][j] + d[i - 1] * d[k] * d[j];
                    if (val < min) {
                        min = val;
                        K[i][j] = k;
                    }
                }
                M[i][j] = min;
            }
        }
        System.out.println(M[1][n-1]);
        for (int i = 0; i < K.length; i++) {
            for (int j = 0; j < K[0].length; j++) {
                System.out.print(K[i][j] + " ");
            }
            System.out.println();
        }
    }
}
