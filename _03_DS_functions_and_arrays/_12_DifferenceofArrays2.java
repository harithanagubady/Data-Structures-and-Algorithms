import java.util.Scanner;

public class _12_DifferenceofArrays2 {
    public static void main(String[] args) throws Exception {

        //find absolute difference irrespective of n1 or n2 greater
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

        int diff[] = new int[Math.max(n1, n2)];
        int c = 0;
        int i = a1.length - 1;
        int j = a2.length - 1;
        int k = diff.length - 1;

        while (k >= 0) {
            int a1v = (i >= 0 ? a1[i] : 0);
            int a2v = (j >= 0 ? a2[j] : 0);
            int d = a1v - a2v + c;
            if (d >= 0) {
                c = 0;
            } else {
                d = d + 10;
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

        if (c == -1) {
            System.out.println("-");
        }
        while (idx < diff.length) {
            System.out.println(diff[idx++]);
        }
    }
}