import java.io.*;
import java.util.*;

public class _02_PrintIncreasing {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        scn.close();
        printIncreasing(n);
    }

    public static void printIncreasing(int n){
        if(n==0) return;
        printIncreasing(n-1);
        System.out.println(n);
    }
}
