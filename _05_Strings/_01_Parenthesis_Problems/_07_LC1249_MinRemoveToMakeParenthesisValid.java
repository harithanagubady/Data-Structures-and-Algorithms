package _01_Parenthesis_Problems;

import java.util.Stack;

/*
https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/description/
 */
public class _07_LC1249_MinRemoveToMakeParenthesisValid {

    public static void main(String[] args) {
        String s = "lee(t(c)o)de)";
        System.out.println(minRemoveToMakeValid1(s));
        System.out.println(minRemoveToMakeValid2(s));
        System.out.println(minRemoveToMakeValid3(s));
        System.out.println(minRemoveToMakeValid4(s));
    }

    public static String minRemoveToMakeValid1(String s) {
        StringBuilder sb = new StringBuilder(s);
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == '(') st.add(i);
            if (sb.charAt(i) == ')') {
                if (!st.empty()) st.pop();
                else sb.setCharAt(i, '*');
            }
        }

        while (!st.empty()) {
            sb.setCharAt(st.pop(), '*');
        }
        return sb.toString().replaceAll("\\*", "");
    }

    public static String minRemoveToMakeValid2(String s) {
        StringBuilder sb = new StringBuilder(s);
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == '(') st.push(i + 1);
            if (sb.charAt(i) == ')') {
                if (!st.empty() && st.peek() >= 0) st.pop();
                else st.push(-(i + 1));
            }
        }

        while (!st.empty()) {
            sb.deleteCharAt(Math.abs(st.pop()) - 1);
        }
        return sb.toString();
    }

    public static String minRemoveToMakeValid3(String s) {
        StringBuilder sb = new StringBuilder(s);
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == '(') st.push(i + 1);
            if (sb.charAt(i) == ')') {
                if (!st.empty() && st.peek() >= 0) st.pop();
                else st.push(-(i + 1));
            }
        }

        StringBuilder ans = new StringBuilder();
        for (int i = 0, j = 0; i < sb.length(); i++) {
            if (j >= st.size() || i != Math.abs(st.elementAt(j)) - 1) {//j >= st.size() means all stack elements are validated
                ans.append(s.charAt(i));
            } else {
                j++;
            }
        }
        return ans.toString();
    }

    public static String minRemoveToMakeValid4(String s) {
        StringBuilder sb = new StringBuilder(s);
        Stack<Integer> st = new Stack<>();
        boolean[] arr = new boolean[s.length()];

        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == '(') st.push(i);
            else if (sb.charAt(i) == ')') {
                if (!st.empty()) {
                    arr[i] = true; //for )
                    arr[(int) st.pop()] = true; //for (
                }
            } else arr[i] = true;
        }

        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < sb.length(); i++) {
            if (arr[i]) ans.append(sb.charAt(i));
        }

        return ans.toString();
    }
}
