import java.util.Scanner;

public class RotateNumber {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int noOfDigits = 0;
        int temp = n;
        while (temp != 0) {
            temp /= 10;
            noOfDigits++;
        }
        k = k % noOfDigits;
        if (k < 0) {
            k = noOfDigits + k;
        }
        int powerK = (int) Math.pow(10, k);
        int div = n / powerK;
        int rem = n % powerK;
        System.out.println((rem * (int) Math.pow(10, noOfDigits - k)) + div);
    }
}
