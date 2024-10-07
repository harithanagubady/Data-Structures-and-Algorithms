import java.util.Scanner;

public class _06_AnyBaseSubtraction {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int b = scn.nextInt();
        int n1 = scn.nextInt(); //smallest
        int n2 = scn.nextInt(); //highest

        boolean flag = false;
        if (n1 > n2) {
            int temp = n1;
            n1 = n2;
            n2 = temp;
            flag = true;
        }
        int d = getDiff(b, n1, n2, flag);
        System.out.println(d);
    }

    private static int getDiff(int b, int n1, int n2, boolean flag) {
        int c = 0, ans = 0, multiplier = 1;
        while (n2 > 0) {
            int n1Digit = n1 % 10;
            int n2Digit = n2 % 10;

            int diff = c + n2Digit - n1Digit;

            int val = diff < 0 ? b + diff : diff;

            c = diff < 0 ? -1 : 0;

            ans += val * multiplier;
            multiplier *= 10;

            n1 /= 10;
            n2 /= 10;
        }
        return flag ? ans * -1 : ans;
    }
}
