import java.util.HashSet;
import java.util.Set;

public class DistinctPalindromicSubstrings {

    public static int countDistinctPalindromicSubstrings(String s) {
        Set<String> distinctPalindromes = new HashSet<>();
        int n = s.length();

        // Dynamic programming table
        boolean[][] dp = new boolean[n][n];

        // Check for single character palindromes
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
            distinctPalindromes.add(String.valueOf(s.charAt(i)));
        }

        // Check for two character palindromes
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = true;
                distinctPalindromes.add(s.substring(i, i + 2));
            }
        }

        // Check for palindromes of length greater than 2
        for (int length = 3; length <= n; length++) {
            for (int i = 0; i <= n - length; i++) {
                int j = i + length - 1;
                if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]) {
                    dp[i][j] = true;
                    distinctPalindromes.add(s.substring(i, j + 1));
                }
            }
        }

        return distinctPalindromes.size();
    }

    public static void main(String[] args) {
        String input = "ccakkabcc";
        int result = countDistinctPalindromicSubstrings(input);
        System.out.println("Count of distinct palindromic substrings: " + result); // Output: 5
    }
}
