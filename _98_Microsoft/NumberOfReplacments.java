import java.util.Arrays;
import java.util.Stack;

public class NumberOfReplacments {

    public static void main(String[] args) {
        String s1 = "RW????";
        String s2 = "???WRR";

        System.out.println(solution(s1, s2));
    }

    private static int solution(String s1, String s2) {
        char[] ch1 = s1.toCharArray();
        Arrays.sort(ch1);
        String sortedS1 = new String(ch1);

        char[] ch2 = s2.toCharArray();
        Arrays.sort(ch2);
        String sortedS2 = new String(ch2);

        System.out.println(sortedS1);
        System.out.println(sortedS2);

        int cq1 = 0, cr1 = 0, cw1 = 0, cq2 = 0, cr2 = 0, cw2 = 0;
        int count = 0, max = Integer.MIN_VALUE;
        for (int i = s2.length() - 1; i >= 0; i--) {
            if (s1.charAt(i) == '?') {
                cq1++;
            } else if (s1.charAt(i) == 'R') {
                cr1++;
                max = Math.max(max, cr1);
            } else if (s1.charAt(i) == 'W') {
                cw1++;
                max = Math.max(max, cw1);
            }
            if (s2.charAt(i) == '?') {
                cq2++;
            } else if (s2.charAt(i) == 'R') {
                cr2++;
                max = Math.max(max, cr2);
            } else if (s2.charAt(i) == 'W') {
                cw2++;
                max = Math.max(max, cw2);
            }
        }

        System.out.println(cr1 + " " + cw1 + " " + cr2 + " " + cw2 + " " + max);
        if (cr1 < max) {
            int diff = max - cr1;
            System.out.println("Line 51, diff: " + diff);
            if (cq1 < diff) {
                return -1;
            }
            count += diff;
            cq1 -= diff;
        }
        if (cw1 < max) {
            int diff = max - cw1;
            System.out.println("Line 60, diff: " + diff);
            if (cq1 < diff) {
                return -1;
            }
            count += diff;
            cq1 -= diff;
        }
        if (cr2 < max) {
            int diff = max - cr2;
            System.out.println("Line 69, diff: " + diff);
            if (cq2 < diff) {
                return -1;
            }
            count += diff;
            cq2 -= diff;

        }
        if (cw2 < max) {
            int diff = max - cw2;
            System.out.println("Line 78, diff: " + diff);
            if (cq2 < diff) {
                return -1;
            }
            count += diff;
            cq2 -= diff;
        }

        return count;
    }
}
