import java.util.Scanner;

public class _02_PrintKpc {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        getKPC(str, "");
    }

    static String[] codes = {".;", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tu", "vwx",
            "yz"
    };

    private static void getKPC(String str, String ans) {

        if (str.length() == 0) {
            System.out.println(ans);
            return;
        }

        String code = codes[str.charAt(0) - '0'];
        String remStr = str.substring(1);

        for (char ch : code.toCharArray()) {
            //System.out.println("Calling getKPC(" + remStr + ", " + (ans+ch) + ")");
            getKPC(remStr, ans + ch);
        }
    }

}
