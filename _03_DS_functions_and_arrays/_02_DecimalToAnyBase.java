import java.util.*;

public class _02_DecimalToAnyBase {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int b = scn.nextInt();
        int dn = getValueInBase(n, b);

        int dn2 = getValueInBase2(n, b);
        System.out.println(dn);
        System.out.println(dn2);
    }

    public static int getValueInBase(int n, int b){
        int ans = 0;
        int multiplier = 1;
        while (n > 0) {
            int rem = n % b;

            n /= b;
            ans = ans + rem * multiplier;
            multiplier *= 10;
        }
        return ans;
    }

    public static int getValueInBase2(int n, int b){
        int ans = 0;
        int multiplier = 0;
        while (n > 0) {
            int rem = n % b;

            n /= b;
            ans = (int) (ans + rem * Math.pow(10, multiplier));
            multiplier += 1;
        }
        return ans;
    }
}