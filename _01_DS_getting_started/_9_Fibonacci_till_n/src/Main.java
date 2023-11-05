import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int a = 0, b = 1, c = b;
        while (n-- > 0) {
            System.out.println(a);
            c = a + b;
            a = b;
            b = c;
        }
    }
}
