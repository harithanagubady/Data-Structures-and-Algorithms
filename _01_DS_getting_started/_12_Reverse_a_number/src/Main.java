import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int temp = n;
        int multiplier = 1;
        while (temp/10 > 0) {
            temp /= 10;
            multiplier *= 10;
        }

        int target = 0;
        while (n > 0) {
            target += (n % 10) * multiplier;
            n /= 10;
            multiplier /= 10;
        }
        System.out.println(target);
    }
}