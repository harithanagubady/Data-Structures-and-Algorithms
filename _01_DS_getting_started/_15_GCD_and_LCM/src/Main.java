import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        //GCD
        int tmp1 = a;
        int tmp2 = b;
        int rem = -1;
        do {
            rem = tmp2 % tmp1;
            tmp2 = tmp1;
            tmp1 = rem;
        } while (rem != 0);
        int GCD = tmp2;

        //LCM
        int LCM = a*b / GCD;
        System.out.println("GCD is: " + GCD + ", LCM is: " + LCM);
    }
}
