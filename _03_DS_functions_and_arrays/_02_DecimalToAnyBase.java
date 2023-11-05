import java.util.*;

public class _02_DecimalToAnyBase {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int b = scn.nextInt();
        int dn = getValueInBase(n, b);
        System.out.println(dn);
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
}