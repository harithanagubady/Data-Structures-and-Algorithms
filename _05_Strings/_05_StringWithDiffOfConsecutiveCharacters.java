import java.util.Scanner;

public class _05_StringWithDiffOfConsecutiveCharacters {

    public static String solution(String str){
        StringBuilder strBuilder = new StringBuilder();
        strBuilder.append(str.charAt(0));
        for (int i = 1; i < str.length(); i++) {
            int diff = str.charAt(i) - str.charAt(i-1);
            strBuilder.append(diff).append(str.charAt(i));
        }

        return strBuilder.toString();
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        System.out.println(solution(str));
    }
}
