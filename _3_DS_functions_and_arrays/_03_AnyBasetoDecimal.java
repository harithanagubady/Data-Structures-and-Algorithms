import java.util.*;

public class _03_AnyBasetoDecimal {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int b = scn.nextInt();
        int d = getValueIndecimal(n, b);
        System.out.println(d);
    }

    public static int getValueIndecimal(int n, int b) {
        int multiplier = 1, ans_num = 0;
        while (n > 0) {
            int remainder = n % 10;
            n = n / 10;
            ans_num += remainder * multiplier;
            multiplier *= b;
        }
        return ans_num;
    }
}