import java.io.*;
import java.util.*;

public class _07_PrintZigZag {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        pzz(n);
    }

    public static void pzz(int n){
        if(n==0) return;
        print(n);
        pzz(n-1);
        print(n);
        pzz(n-1);
        print(n);
    }

    public static void print(int n) {
        System.out.print(n+ " ");
    }
}
