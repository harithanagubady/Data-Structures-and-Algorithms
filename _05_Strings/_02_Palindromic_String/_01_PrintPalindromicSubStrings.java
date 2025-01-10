package _02_Palindromic_String;

import java.util.Scanner;

public class _01_PrintPalindromicSubStrings {

    //O(n^2 * m) - m is size of substring
    public static int solution1BruteForce(String str){

        int count = 0;
        for(int i=0; i<str.length(); i++){
            for(int j=i+1; j<=str.length();j++){
                String substr = str.substring(i,j);
                if(isPalindrome(substr)){
                    count++;
                    System.out.println(substr);
                }
            }
        }
        return count;
    }

    public static boolean isPalindrome (String str){
        int i = 0;
        int j = str.length()-1;
        while(i<j){
            if(str.charAt(i)!=str.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        System.out.println(solution1BruteForce(str));
    }

}