package _01_Parenthesis_Problems;

/*
https://www.geeksforgeeks.org/number-of-balanced-parenthesis-substrings/
 */
public class _08_NumberOfBalancedParenthesisSubStrings {

    public static void main(String[] args) {

        String s1 = "()()()"; //output: 6 (), (), (), ()(), ()(), ()()()
        String s2 = "(())()"; //output: 4 (), (()), (), (())()
        String s3 = "(()(()))()";
        System.out.println(findNumberOfBalanced(s1));
        System.out.println(findNumberOfBalanced(s2));
        System.out.println(findNumberOfBalanced(s3));
    }

    private static int findNumberOfBalanced(String str) {
        int count = 0, n = str.length();
        int depth = 0;
        int[] arr = new int[n / 2 + 1];
        for (int i = 0; i < n; i++) {
            if (str.charAt(i) == '(') {
                depth++;
            } else {
                if (depth == 1) {
                    for (int j = 2; j < n / 2 + 1 && arr[j] != 0; j++) {
                        arr[j] = 0;
                    }
                }
                count = ++count + arr[depth--]++;
                /*
                above expression is:
                ++count;
                count += arr[depth];
                arr[depth]++;
                depth--;
                 */
            }
        }
        return count;
    }
}
