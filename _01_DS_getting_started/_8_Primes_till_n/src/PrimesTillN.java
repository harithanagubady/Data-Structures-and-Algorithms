import java.util.Scanner;

public class PrimesTillN {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int start = scanner.nextInt();
        int end = scanner.nextInt();
        for (int i = start; i <= end; i++) {
            boolean isPrime = true;
            if(i==2) {
                continue;
            }
            for (int div = 2; div*div <=i ; div++) {
                if (i%div == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                System.out.println(i);
            }
        }
    }
}
