import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int pos = 1;
        int result = 0;
        while (num != 0) { //temp = 21453
            int dig = num % 10; // dig = 3
            result += pos * (int) Math.pow(10, (dig - 1));
            num /= 10; // temp = 2145
            pos++;
        }
        System.out.println(result);
    }
}
