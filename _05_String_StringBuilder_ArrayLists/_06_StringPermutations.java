import java.util.Scanner;

public class _06_StringPermutations {

    public static void solution(String str) {

        int length = str.length();
        long fact = factorial(length);

        for (long i = 0; i < fact; i++) {
            StringBuilder temp = new StringBuilder(str);
            long q = i;
            StringBuilder ans = new StringBuilder();
            for (int divisor = length; divisor >= 1; divisor--) {
                int rem = (int) q % divisor;
                ans.append(temp.charAt(rem));
                temp.deleteCharAt(rem);
                q /= divisor;
            }
            System.out.println(ans);
        }
    }

    private static long factorial(int n) {
        if (n == 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        solution(str);
    }
}
