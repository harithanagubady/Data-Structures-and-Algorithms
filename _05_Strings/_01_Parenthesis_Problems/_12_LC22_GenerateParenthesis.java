package _01_Parenthesis_Problems;

import java.util.ArrayList;
import java.util.List;

public class _12_LC22_GenerateParenthesis {

    public static void main(String[] args) {
        int n = 3;
        List<String> ans = new ArrayList<>();
        generateParenthesis(n, n, "", ans);
        for (String s : ans) {
            System.out.println(s);
        }
    }

    private static void generateParenthesis(int m, int n, String str, List<String> ans) {
        if (m == 0 && n == 0) {
            ans.add(str);
            return;
        }

        if (m > 0) generateParenthesis(m - 1, n, str + "(", ans);
        if (n != m) generateParenthesis(m, n - 1, str + ")", ans);
    }
}
