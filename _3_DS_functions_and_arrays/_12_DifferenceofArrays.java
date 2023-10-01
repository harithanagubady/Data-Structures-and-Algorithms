import java.util.*;

public class _12_DifferenceofArrays {

    public static void main(String[] args) throws Exception {
        // a2>a1
        Scanner scn = new Scanner(System.in);
        int n1 = scn.nextInt();
        int a1[] = new int[n1];

        for (int i = 0; i < a1.length; i++) {
            a1[i] = scn.nextInt();
        }

        int n2 = scn.nextInt();
        int a2[] = new int[n2];

        for (int i = 0; i < a2.length; i++) {
            a2[i] = scn.nextInt();
        }

        int diff[] = new int[n2];
        int c = 0;
        int i = a1.length - 1;
        int j = a2.length - 1;
        int k = diff.length - 1;

        while (k >= 0) {
            int d = 0;
            int a1v = (i >= 0 ? a1[i] : 0);
            if (a2[j] + c >= a1v) {
                d = a2[j] + c - a1v;
                c = 0;
            } else {
                d = a2[j] + 10 + c - a1v;
                c = -1;
            }

            diff[k] = d;
            i--;
            j--;
            k--;
        }

        int idx = 0;
        while (idx < diff.length && diff[idx] == 0) {
            idx++;
        }

        while (idx < diff.length) {
            System.out.println(diff[idx++]);

        }
    }
}