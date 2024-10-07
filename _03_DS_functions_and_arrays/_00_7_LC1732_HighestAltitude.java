/*
https://leetcode.com/problems/find-the-highest-altitude/description/
 */
public class _00_7_LC1732_HighestAltitude {

    public static void main(String[] args) {
        int[] gain = new int[] {-5,1,5,0,-7};
        int n = gain.length;
        int[] altitudes = new int[n + 1];
        int max = altitudes[0];
        for (int i = 1; i <= n; i++) {
            altitudes[i] = altitudes[i - 1] + gain[i - 1];
            max = Math.max (max, altitudes[i]);
        }
        System.out.println(max);
    }
}
