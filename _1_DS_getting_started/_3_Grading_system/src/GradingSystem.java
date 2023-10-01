import java.util.Scanner;

public class GradingSystem {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        int base = scanner.nextInt();
        scanner.close();
        int final_num = toDecimal(number, base);
        System.out.println(final_num);
    }

    private static int toDecimal(int number, int base) {
        int result = 0;
        int multiplier = 0;
        while (number > 0) {
            int remainder = number % 10;
            number /= 10;
            result = result + remainder * (int)Math.pow(base, multiplier);
            multiplier++;
        }
        return result;
    }
}
