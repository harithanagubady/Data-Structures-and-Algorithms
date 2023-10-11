import java.util.Scanner;

public class _06_AnyBaseSubtraction {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int b = scn.nextInt();
        int n1 = scn.nextInt(); //smallest
        int n2 = scn.nextInt(); //highest

        int d = getDiff(b, n1, n2);
        System.out.println(d);
    }

    private static int getDiff(int b, int n1, int n2) {
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
        return ans;
    }
}

//import java.io.*;
//
//import java.util.*;
//
//public class Main {
//
//    public static void main(String[] args) {
//        Scanner scn = new Scanner(System.in);
//        int b = scn.nextInt();
//        int n1 = scn.nextInt();
//        int n2 = scn.nextInt();
//
//        int d = getDifference(b, n1, n2);
//        System.out.println(d);
//    }
//
//    public static int getDifference(int b, int n1, int n2) {
//        int rv = 0;
//
//        int c = 0;
//        int p = 1;
//        while (n2 > 0) {
//            int d1 = n1 % 10;
//            int d2 = n2 % 10;
//            n1 = n1 / 10;
//            n2 = n2 / 10;
//
//            int d = d2 - d1 - c;
//
//            if (d < 0) {
//                c = 1;
//                d += b;
//            } else {
//                c = 0;
//            }
//
//            rv += d * p;
//            p = p * 10;
//        }
//
//        return rv;
//    }
//
//}