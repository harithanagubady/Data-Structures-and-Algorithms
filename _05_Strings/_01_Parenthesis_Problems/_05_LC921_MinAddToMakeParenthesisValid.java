package _01_Parenthesis_Problems;

/*
https://leetcode.com/problems/minimum-add-to-make-parentheses-valid/description/
 */
public class _05_LC921_MinAddToMakeParenthesisValid {

    public static void main(String[] args) {
        System.out.println(minAddToMakeValid(")))"));
    }

    public static int minAddToMakeValid(String s) {
        //we need "right" bracket when we encounter ( --> right++
        //we found "right" bracket when we encounter ) --> right--
        //we need "left" bracket when we encounter ) and there is no left bracket right = 0, so left++

        int right = 0, left = 0;
        for (char ch : s.toCharArray()) {
            //when '('
            if (ch == '(') right++;

            //when ')'
            else if (right > 0) right--;
            else left++;
        }
        return left + right;
    }
}
