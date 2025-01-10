package _01_Parenthesis_Problems;

import java.util.Stack;

/*
https://leetcode.com/problems/valid-parentheses/
 */
public class _01_LC20_ValidParenthesis {

    public static void main(String[] args) {
        String s = "(([]))";
        System.out.println(isValid3(s));
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '['){
                stack.push(c);
                continue;
            }
            if (stack.isEmpty()) {
                if (c == ')' || c == '}' || c == ']') return false;
            } else {
                char popped = stack.pop();
                if ((c == ')' && popped == '(') || (c == ']' && popped == '[') || (c == '}' && popped == '{')) {
                }
                else return false;
            }
        }
        return stack.isEmpty();
    }

    //more efficient
    public static boolean isValid2(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (char c : s.toCharArray()) {
            if (c == '(')
                stack.push(')');
            else if (c == '{')
                stack.push('}');
            else if (c == '[')
                stack.push(']');
            else if (stack.isEmpty() || stack.pop() != c)
                return false;
        }
        return stack.isEmpty();
    }

    public static boolean isValid3(String s) {
        char[] stack = new char[s.length()];
        int i = -1;
        for (char c : s.toCharArray()) {
            if (c == '(')
                stack[++i] = ')';
            else if (c == '{')
                stack[++i] = '}';
            else if (c == '[')
                stack[++i] = ']';
            else {
                if (i == -1 || stack[i--] != c)
                    return false;
            }
        }
        return i == -1;
    }
}
