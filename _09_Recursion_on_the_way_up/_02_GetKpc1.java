import java.util.ArrayList;
import java.util.Scanner;

public class _02_GetKpc1 {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        ArrayList<String> words = getKPC(str);
        System.out.println(words);
    }

    static String[] codes = {".;", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tu", "vwx",
            "yz"
    };

    private static ArrayList<String> getKPC(String str) {

        if(str.length() == 0) {
            return new ArrayList<>();
        }

        String code = codes[str.charAt(0) - '0'];
        String remStr = str.substring(1);

        ArrayList<String> subStrings = getKPC(remStr);

        ArrayList<String> result = new ArrayList<>();
        for (char ch : code.toCharArray()) {
            for (String subString : subStrings) {
                result.add(ch + subString);
            }
        }
        return result;
    }

}
