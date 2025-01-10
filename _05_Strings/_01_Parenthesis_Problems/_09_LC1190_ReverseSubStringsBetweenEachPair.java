package _01_Parenthesis_Problems;

import java.util.Stack;

public class _09_LC1190_ReverseSubStringsBetweenEachPair {

    public static void main(String[] args) {
        String s = "(ed(et(oc))el)";
        System.out.println(reverseParentheses1(s));
        System.out.println(reverseParentheses2(s));
    }

    public static String reverseParentheses1(String s) {
        int n = s.length();
        Stack<Integer> st = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; ++i) {
            if (s.charAt(i) == '(')
                st.push(sb.length());
            else if (s.charAt(i) == ')') {
                int idx = st.pop();
                sb = new StringBuilder(sb.substring(0, idx))
                        .append(new StringBuilder(sb.substring(idx)).reverse());
            } else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }

    public static String reverseParentheses2(String s) {
        int n = s.length();
        Stack<Integer> opened = new Stack<>();
        int[] pair = new int[n];
        for (int i = 0; i < n; ++i) {
            if (s.charAt(i) == '(')
                opened.push(i);
            if (s.charAt(i) == ')') {
                int j = opened.pop();
                pair[i] = j;
                pair[j] = i;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0, d = 1; i < n; i += d) {
            if (s.charAt(i) == '(' || s.charAt(i) == ')') {
                i = pair[i];
                d = -d;
            } else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}
