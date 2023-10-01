import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();

        int max = findMax(a, b, c);
        if (max == a) {
            System.out.println(b * b + c * c == a * a);
        } else if (max == b) {
            System.out.println(a * a + c * c == b * b);
        } else {
            System.out.println(a * a + b * b == c * c);
        }
    }

    private static int findMax(int a, int b, int c) {
        int max = 0;
        if (a > max) {
            max = a;
        }
        if (b > max) {
            max = b;
        }
        if (c > max) {
            max = c;
        }
        return max;
    }
}
