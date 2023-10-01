import java.util.Scanner;

public class SameOrder {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int pow = 0;
        int temp = num;
        while (temp != 0) {
            pow++;
            temp /= 10;
        }
        int div = (int) Math.pow(10, pow - 1);
        int temp1 = num;
        while (div != 0) {
            System.out.println(temp1 / div);
            temp1 %= div;
            div/=10;
        }
    }
}
