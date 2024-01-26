import java.util.ArrayList;
import java.util.Scanner;

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

    public static ArrayList<String> getKPC(String str) { //578
        if(str.length() == 0) {
            String initialStr = "";
            ArrayList<String> l = new ArrayList<>();
            l.add(initialStr);
            return l;
        }
        char ch = str.charAt(0); //5
        str = str.substring(1);
        ArrayList<String> substrs = getKPC(str); //78
        String code = codes[ch - '0'];    //"mno"
        ArrayList<String> arrList = new ArrayList<>();
        for (String substr : substrs) { // tv, tw, tx, uv, uw, ux
            for (char c : code.toCharArray()) { // m, n, o
                arrList.add(c + substr); //mtv, mtw, mtx, ....., mux, ntv, ntw, ntx, .... nux, otv, otw, otx, ...., oux
            }
        }
        return arrList;
    }

}