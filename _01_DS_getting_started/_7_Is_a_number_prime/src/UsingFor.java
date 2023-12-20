import java.util.Scanner;

public class UsingFor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = 0;
        System.out.println("Enter no. of inputs: " + (n = scanner.nextInt()));
        System.out.println("Enter values: ");
        for (int i = 0; i < n; i++) {
            int x = scanner.nextInt();
            System.out.println(isPrime(x));
        }
    }

    private static String isPrime(int x) {
        if (x == 1) return "not prime";
        if (x == 2) return "prime";
        for (int div = 2; div * div <= x; div++) {
            if (x % div == 0) return "not prime";
        }
        return "prime";
    }
}
