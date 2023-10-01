import java.util.*;

public class _1_DigitFrequency {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int d = scn.nextInt();
        int f = getDigitFrequency(n, d);
        System.out.println(f);
    }

    public static int getDigitFrequency(int n, int d) {
        int rv =0;
        while(n>0) {
            if (n%10 == d) {
                rv++;
            }
            n/=10;
        }
        return rv;
    }
}