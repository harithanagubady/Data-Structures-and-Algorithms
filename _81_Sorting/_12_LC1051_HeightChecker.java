/*
https://leetcode.com/problems/height-checker/description/
 */

public class _12_LC1051_HeightChecker {

    public static void main(String[] args) {
        int[] heights = {1, 1, 4, 2, 1, 3};
        System.out.println(heightChecker(heights));
    }

    //Counting Sort - O(n)
    public static int heightChecker(int[] heights) {
        int[] count = new int[101];
        for (int i : heights) {
            count[i]++;
        }

        int expHeight = 0;
        int mismatch = 0;
        for (int height : heights) {
            while (count[expHeight] == 0) expHeight++;//find height that is present in the input
            if (height != expHeight) {
                //when expected height according to count array is not equal to current height,
                //then it is a mismatch
                mismatch++;
            }
            count[expHeight]--; //1 comparison is complete, so reduce count
        }

        return mismatch;
    }
}
