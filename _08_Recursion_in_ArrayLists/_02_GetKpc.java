import java.io.*;

import java.lang.reflect.Array;
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
        if(str.length() == 0) {
            String initialStr = "";
            ArrayList<String> l = new ArrayList<>();
            l.add(initialStr);
            return l;
        }
        char ch = str.charAt(0);
        str = str.substring(1);
        ArrayList<String> substrs = getKPC(str);
        String code = codes[ch - '0'];
        ArrayList<String> arrList = new ArrayList<>();
        for (String substr : substrs) {
            for (char c : code.toCharArray()) {
                arrList.add(c + substr);
            }
        }
        return arrList;
    }

}