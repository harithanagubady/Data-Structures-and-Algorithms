public class _19_LC9_PalindromeNumber {
    public static void main(String[] args) {
        int x = 101;
        int temp = x;
        int reversed = 0;
        while (temp > 0) {
            int digit = temp % 10;
            reversed = reversed * 10 + digit;
            temp /= 10;
        }
        System.out.println(reversed == x);
    }
}
