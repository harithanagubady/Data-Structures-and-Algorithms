import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;

public class _04_StockSpan {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[] a = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = scn.nextInt();
        }

        int[] span = solve(a);
        display(span);
    }

    public static int[] solve(int[] a) {

        int[] span = new int[a.length];
        Stack<Integer> s = new Stack<>();
        s.push(0);
        span[0] = 1;

        for (int i = 1; i < a.length; i++) {
            while (!s.isEmpty() && s.peek() < a[i]) {
                s.pop();
            }
            if (s.size() == 0) {
                span[i] = i + 1;
            } else {
                span[i] = i - s.peek() + 1;
            }
            s.push(i);
        }
        return span;
    }

    private static void display(int[] span) {
        for (int i : span) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
