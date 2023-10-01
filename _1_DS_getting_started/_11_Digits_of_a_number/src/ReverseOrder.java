import java.util.Scanner;

public class ReverseOrder {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        while (num != 0) {
            System.out.println(num%10);
            num/=10;
        }
    }
}
