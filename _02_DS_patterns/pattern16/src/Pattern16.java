import java.util.Scanner;

public class Pattern16 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int num = scn.nextInt();

        for (int i = 1; i <= num; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + "\t");
            }
            for (int j = 1; j <= 2 * num - 2 * i - 1; j++) {
                System.out.print("\t");
            }
            for (int j = i; j >= 1; j--) {
                if (i == num && j == i) {
                    continue;
                }
                System.out.print(j + "\t");
            }
            System.out.println();
        }
    }
}
