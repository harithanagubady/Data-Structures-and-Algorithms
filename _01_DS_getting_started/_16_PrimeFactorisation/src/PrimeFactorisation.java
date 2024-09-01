import java.util.Scanner;

public class PrimeFactorisation {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();

        for (int i = 2; i * i <= num; i++) {
            System.out.println("num" + num);
            while (num % i == 0) {
                num /= i;
                System.out.println(i);
            }
        }
        if (num != 1) {
            System.out.println(num);
        }
    }
}
