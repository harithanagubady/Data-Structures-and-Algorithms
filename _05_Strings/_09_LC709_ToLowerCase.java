/*
https://leetcode.com/problems/to-lower-case/description/
 */

public class _09_LC709_ToLowerCase {

    public static String toLowerCase(String s) {
        char[] ch = s.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            if (ch[i] >= 'A' && ch[i] <= 'Z') {
                ch[i] = (char) (ch[i] - 'A' + 'a');
            }
        }
        return new String (ch);
    }

    public static void main(String[] args) {
        System.out.println(toLowerCase("Haritha"));
    }
}
