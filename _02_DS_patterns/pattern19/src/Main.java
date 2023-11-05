import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int num = scn.nextInt();

        for (int i = 1; i <= num; i++) {

            //first pattern
            if (i == 1) {
                for (int j = 1; j <= num; j++) {
                    if (j <= num / 2 + 1 || j == num) {
                        System.out.print("*   ");
                    } else {
                        System.out.print("    ");
                    }
                }
            }
            //second pattern
            else if (i <= num / 2) {
                for (int j = 1; j <= num; j++) {
                    if (j == num / 2 + 1 || j == num) {
                        System.out.print("*   ");
                    } else {
                        System.out.print("    ");
                    }
                }
            }
            //third pattern
            else if (i == num / 2 + 1) {
                for (int j = 1; j <= num; j++) {
                    System.out.print("*   ");
                }
            }
            //fourth pattern
            else if (i > num / 2 && i < num) {
                for (int j = 1; j <= num; j++) {
                    if (j == num / 2 + 1 || j == 1) {
                        System.out.print("*   ");
                    } else {
                        System.out.print("    ");
                    }
                }
            } else {
                for (int j = 1; j <= num; j++) {
                    if (j >= num / 2 + 1 || j == 1) {
                        System.out.print("*   ");
                    } else {
                        System.out.print("    ");
                    }
                }
            }
            System.out.println();
        }
    }
}
