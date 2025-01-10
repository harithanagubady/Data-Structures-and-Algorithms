package _01_Parenthesis_Problems;

/*
https://leetcode.com/problems/minimum-insertions-to-balance-a-parentheses-string/description/
 */
public class _06_LC1541_MinInsertionsToBalanceParenthesis {

    public static void main(String[] args) {
        String s = "(()))(()))()()))";
        System.out.println(minInsertions(s));
    }

    public static int minInsertions(String s) {
        int left = 0, right = 0, need = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                if (right % 2 > 0) {
                    need++;
                    right--;
                }
                right += 2;
            }
            else if (right > 0) right--;
            else {
                right++;
                left++;
            }
        }
        return left + right + need;
    }
}
