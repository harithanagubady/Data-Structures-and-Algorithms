package _01_Parenthesis_Problems;

/*
https://leetcode.com/problems/maximum-nesting-depth-of-two-valid-parentheses-strings/description/
 */

import java.util.Arrays;

public class _04_LC1111_MaxNestingDepthOfTwoParenthesis {

    public static void main(String[] args) {
        String seq = "((()))";
        int[] ans = maxDepthAfterSplit(seq);
        System.out.println(Arrays.toString(ans));

        ans = maxDepthAfterSplit2(seq);
        System.out.println(Arrays.toString(ans));

        ans = maxDepthAfterSplit3(seq);
        System.out.println(Arrays.toString(ans));
    }

    public static int[] maxDepthAfterSplit3(String seq) {
        int n = seq.length();
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = seq.charAt(i) == '(' ? (i & 1) : (1 - i & 1);
        }
        return res;
    }

    public static int[] maxDepthAfterSplit2(String seq) {
        int n = seq.length();
        int[] res = new int[n];
        int A = 0, B = 0;
        for (int i = 0; i < n; i++) {
            if (seq.charAt(i) == '(') {
                if (A <= B) {
                    A++;
                } else {
                    B++;
                    res[i] = 1;
                }
            } else {
                if (A <= B) {
                    B--;
                    res[i] = 1;
                } else {
                    A--;
                }
            }
        }
        return res;
    }

    public static int[] maxDepthAfterSplit(String seq) {
        int n = seq.length();
        int depth = 0, curr = 0;
        for (int i = 0; i < n; i++) {
            curr += seq.charAt(i) == '(' ? 1 : -1;
            depth = Math.max(curr, depth);
        }
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            if (seq.charAt(i) == '(') {
                if (++curr > depth / 2) {
                    res[i] = 1;
                }
            } else {
                if (curr-- > depth / 2) {
                    res[i] = 1;
                }
            }
        }
        return res;
    }
}
