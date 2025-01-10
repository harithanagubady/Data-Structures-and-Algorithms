package _01_Parenthesis_Problems;

/*
https://leetcode.com/problems/maximum-nesting-depth-of-the-parentheses/description/
 */
public class _03_LC1614_MaxNestingDepth {

    public static void main(String[] args) {
        String s = "(1+(2*3)+((8)/4))+1";
        System.out.println(maxDepth(s));
    }
    public static int maxDepth(String s) {
        int depth = 0, maxDepth = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                maxDepth = Math.max(++depth, maxDepth);
            }
            else if (s.charAt(i) == ')') {
                depth--;
            }
        }
        return maxDepth;
    }
}
