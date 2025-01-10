package _01_Parenthesis_Problems;/*
https://leetcode.com/problems/remove-outermost-parentheses/
 */

import java.util.Stack;

public class _02_LC1021_RemoveOutermostParenthesis {
    public static void main(String[] args) {
        String s = "(()())(())";
        System.out.println(removeOuterParentheses2(s));
    }

    public static String removeOuterParentheses(String s) {
        Stack<Character> unpaired = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                if (!unpaired.isEmpty()) sb.append(ch);
                unpaired.push(ch);
            }
            if (ch == ')') {
                unpaired.pop();
                if (!unpaired.isEmpty()) sb.append(ch);
            }
        }
        return sb.toString();
    }

    public static String removeOuterParentheses2(String s) {
        int opened = 0;
        StringBuilder sb = new StringBuilder();
        for (char ch : s.toCharArray()) {
            if (ch == '(' && opened++ > 0) sb.append(ch);
            if (ch == ')' && --opened > 0) sb.append(ch);
        }
        return sb.toString();
    }
}
