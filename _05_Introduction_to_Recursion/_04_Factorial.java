import java.io.*;
import java.util.*;


public class _04_Factorial {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        System.out.println(factorial(n));
    }

    public static int factorial(int n){
        if(n==1) return 1;
        return n*factorial(n-1);
    }

}