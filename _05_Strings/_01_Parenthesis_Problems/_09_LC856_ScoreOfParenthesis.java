package _01_Parenthesis_Problems;

/*
https://leetcode.com/problems/score-of-parentheses/
 */
import java.util.Stack;

public class _09_LC856_ScoreOfParenthesis {

    public static void main(String[] args) {
        //String s = "(()(()()))";
        String s = "()()()";
        System.out.println(scoreOfParenthesesConstantSpace(s));
    }

    //O(N) O(N)
    public static int scoreOfParenthesesUsingStack(String s) {
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') st.push(-1);
            else {
                if (st.peek() == -1) {
                    st.pop();
                    st.push(1);
                } else {
                    int A = 0;
                    while (st.peek() != -1) {
                        A += st.pop();
                    }
                    st.pop();
                    st.push(2 * A);
                }
            }
        }
        int ans = 0;
        while (!st.isEmpty()) {
            ans += st.pop();
        }

        return ans;
    }

    //O(N)  O(N)
    public static int scoreOfParenthesesUsingStack2(String s) {
        Stack<Integer> st = new Stack<>();
        int A = 0;
        for (int i = 0; i < s.length(); i++) {
            //(A) = 2*A; () = 1
            //let A = 0 => (A) = () = 1  --> 1
            //let A != 0 => (A) = 2*A    --> 2
            //from 1 & 2, A = max(2*A, 1) => if A = 0, gives 1 and if A != 0, gives 2*A

            if (s.charAt(i) == '(') {
                st.push(A);
                A = 0; //reset A
            }
            else {
                A = st.pop() + Math.max (2 * A, 1);//() -> 0 + 1
                //(()) -> (1) i.e., A is 1 -> 0 + 2*A -> 0 + 2*1 = 2
            }
        }

        return A;
    }

    //Tree method O(N) O(N)
    public static int scoreOfParenthesesUsingArray(String s) {
        int[] res = new int[30];
        int level = 0;
        for (char ch : s.toCharArray()) {

            //go further depth initialise level + 1
            if (ch == '(') res[++level] = 0;
            //if ) come back one level and calculate result
            else {
                res[level - 1] += Math.max(2 * res[level--], 1);
            }
        }
        //Thus calculate each level values and return 0th level value
        return res[0];
    }

    //O(N)  O(1)
    public static int scoreOfParenthesesConstantSpace(String s) {
        int level = 0;
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(') ++level;
            else --level;

            if (ch == ')' && s.charAt(i - 1) == '(') { //skipping internal nodes
                // an internal node doesn't have immediate '(' to the left of ')' since it has children
                //implies if current node is ')' its previous bracket could be (), ()()... where these are children
                res += (1 << level);
                System.out.println(res);
            }
        }
        //Thus calculate each level values and return 0th level value
        return res;
    }
}
