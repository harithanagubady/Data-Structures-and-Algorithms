import java.util.*;

public class _07_AnyBaseMultiplication {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int b = scn.nextInt();
        int n1 = scn.nextInt();
        int n2 = scn.nextInt();

        int d = getProduct(b, n1, n2);
        System.out.println(d);
    }

    public static int getProduct(int b, int n1, int n2) {

        int finalProduct = 0, multiplier = 1;
        while (n2 > 0) {
            int digit = n2 % 10;
            int productWithDigit = getProductWithDigit(b, digit, n1);
            finalProduct = getSum(b, multiplier * productWithDigit, finalProduct);
            n2 /= 10;
            multiplier *= 10;
        }
        return finalProduct;
    }

    private static int getProductWithDigit(int b, int digit, int n1) {
        int carry = 0, ans = 0, multiplier = 1;
        while (n1 > 0 || carry > 0) {
            int n1Digit = n1 % 10;
            int product = n1Digit * digit + carry;
            carry = product / b;
            int value = product % b;
            ans += value * multiplier;
            multiplier *= 10;
            n1/=10;
        }
        return ans;
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