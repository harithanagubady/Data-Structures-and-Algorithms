import java.util.Stack;

/*
https://leetcode.com/problems/longest-valid-parentheses/description/
 */
public class _32_LongestValidParenthesis {
    public int longestValidParentheses(String s) {
        char[] chArray = s.toCharArray();
        int n = s.length();
        Stack<Integer> chStack = new Stack<>();
        int longest = 0;
        for (int i = 0; i < n; i++) {
            if (chArray[i] == ')' && !chStack.isEmpty() && chArray[chStack.peek()] == '(') {
                chStack.pop();
            } else {
                chStack.push(i);
            }
        }
        if (chStack.isEmpty()) {
//when stack is empty, complete string is a valid one, return length of string
            longest = n;
        } else {
            int high = n, low = 0;
//when stack is not empty, evaluate all valid parenthesis between indexes in the stack
            while (!chStack.isEmpty()) {
                low = chStack.pop();
                longest = Math.max(longest, high - low - 1);
                high = low;
            }
            longest = Math.max(longest, high);
        }
        return longest;
    }

    public int longestValidParenthesesDPApproach(String s) {
        int n = s.length();
        if (n <= 1) return 0;
        int[] dp = new int[n];
        int longest = 0;
        for (int i = 1; i < n; i++) {
            int prevOfLastValid = i - dp[i - 1] - 1;
            if (s.charAt(i) == ')' && prevOfLastValid >= 0 && s.charAt(prevOfLastValid) == '(') {
                dp[i] = dp[i - 1] + 2 +
                        ((prevOfLastValid - 1 >= 0) ? dp[prevOfLastValid - 1] : 0);
                longest = Math.max(longest, dp[i]);
            }
        }
        return longest;
    }

    public static void main(String[] args) {
        String s = "(((()))))))";
        int count = new _32_LongestValidParenthesis().longestValidParentheses(s);
        System.out.println(count);
        count = new _32_LongestValidParenthesis().longestValidParenthesesDPApproach(s);
        System.out.println(count);
    }
}