import java.util.Scanner;

public class _5_AnyBaseAddition {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int b = scn.nextInt();
        int n1 = scn.nextInt();
        int n2 = scn.nextInt();

        int d = getSum(b, n1, n2);
        System.out.println(d);
    }

    private static int getSum(int b, int n1, int n2) {
        int c = 0, ans = 0, multiplier = 1;
        while (n1 > 0 || n2 > 0 || c > 0) {
            int n1Digit = n1 % 10;
            int n2Digit = n2 % 10;

            int sumOfDigits = n1Digit + n2Digit + c;

            c = sumOfDigits / b;
            int val = sumOfDigits % b;

            ans += val * multiplier;
            multiplier *= 10;

            n1 /= 10;
            n2 /= 10;
        }
        return ans;
    }
}
