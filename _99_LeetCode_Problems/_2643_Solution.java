public class _2643_Solution {

    public static void main(String[] args) {
//        int[][] mat = {{0, 0, 0, 1},
//                {0, 1, 1, 1},
//                {1, 1, 1, 1},
//                {0, 0, 0, 0}};

        int[][] mat = {{0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0}};
        int[] ans = rowAndMaximumOnes(mat);
        System.out.println("Index of row with maximum 1s is: "
                + ans[0]);
        System.out.println("No. of 1s: "
                + ans[1]);
    }

    public static int[] rowAndMaximumOnes(int[][] mat) {

        int noOfCol = mat[0].length - 1, c = noOfCol;
        int rowWithMaxOnes = -1;
        for (int r = 0; r < mat.length; r++) {
            while (c >= 0 && mat[r][c] == 1) {
                c -= 1;
                rowWithMaxOnes = r;
            }
        }
        int[] ans = new int[2];
        ans[0] = rowWithMaxOnes;
        ans[1] = noOfCol - c;
        return ans;
    }
}
