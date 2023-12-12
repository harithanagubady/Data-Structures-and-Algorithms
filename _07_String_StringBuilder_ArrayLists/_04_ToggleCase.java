import java.util.*;

public class _04_ToggleCase {

    public static String toggleCase(String str) {
        StringBuilder sb = new StringBuilder(str);
        for (int i = 0; i < sb.length(); i++) {
            char ch = sb.charAt(i);
            if (ch >= 'A' && ch <= 'Z') {
                sb.setCharAt(i, (char) (ch - 'A' + 'a'));
            } else if (ch >= 'a' && ch <= 'z') {
                sb.setCharAt(i, (char) (ch - 'a' + 'A'));
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        System.out.println(toggleCase(str));
    }

}