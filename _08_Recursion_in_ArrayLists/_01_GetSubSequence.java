import java.util.ArrayList;
import java.util.Scanner;

public class _01_GetSubSequence {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String s = scn.nextLine();
        ArrayList<String> subStrings = gss(s);
        for (String substr : subStrings) {
            System.out.println(substr);
        }
    }

    private static ArrayList<String> gss(String s) {
        if (s.length() == 0) {
            ArrayList<String> newList = new ArrayList<>();
            newList.add("");
            return newList;
        }
        char ch = s.charAt(0);
        String remSubStr = s.substring(1);
        ArrayList<String> substrs = gss(remSubStr);
        ArrayList<String> resSubStr = new ArrayList<>();
        for (String substr : substrs) {
            resSubStr.add("" + substr);
            resSubStr.add(ch + substr);
        }
        return resSubStr;
    }
}
