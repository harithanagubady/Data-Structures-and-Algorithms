import java.io.*;

import java.util.*;

public class _02_GetKpc {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        ArrayList<String> words = getKPC(str);
        System.out.println(words);
    }

    static String[] codes = {".;", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tu", "vwx",
            "yz"
    };

    public static ArrayList<String> getKPC(String str) {
        if (str.length() == 0) {
            ArrayList<String> bres = new ArrayList<>();
            bres.add("");
            return bres;
        }

        char ch = str.charAt(0);   //0
        String remStr = str.substring(1);
        ArrayList<String> subStrs = getKPC(remStr);         //"ty", "tz", "uy", "uz"
        ArrayList<String> mres = new ArrayList<>();

        String getStrForNum = codes[ch - '0'];             //".;"

        for (int i = 0; i < getStrForNum.length(); i++) {  //
            char curCh = getStrForNum.charAt(i);          //"."
            for (String subStr : subStrs) {
                mres.add(curCh + subStr);             //concatenate current current string's characters with previous substrings
            }
        }
        return mres;
    }

}