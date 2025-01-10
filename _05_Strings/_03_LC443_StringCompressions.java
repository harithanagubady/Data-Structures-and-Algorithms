import java.util.*;

/*
https://leetcode.com/problems/string-compression/description/
 */
public class _03_LC443_StringCompressions {

    //aabbccc => abc
    public static String compression1(String str) {
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            while (i < str.length() - 1 && str.charAt(i) == str.charAt(i + 1)) {
                i++;
            }
            ans.append(str.charAt(i));
        }

        return ans.toString();
    }

    //aabbccc => a2b2c3
    public static String compression2(String str) {
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            int count = 1;
            while (i < str.length() - 1 && str.charAt(i) == str.charAt(i + 1)) {
                count++;
                i++;
            }
            ans.append(str.charAt(i));
            if (count > 1) {
                ans.append(count);
            }
        }

        return ans.toString();
    }

    //leetcode solution
    //aabbccc => a2b2c3
    public static int compression3(char[] chars) {
        int n = chars.length;

        int ansIdx = 0, i = 0;
        while (i < n) {
            int count = 0;
            char curr = chars[i];
            while (i < n && curr == chars[i]) {
                count++;
                i++;
            }
            chars[ansIdx++] = curr;
            if (count > 1) {
                for (char ch : Integer.toString(count).toCharArray()){
                    chars[ansIdx++] = ch;
                }
            }
        }
        return ansIdx;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        System.out.println(compression1(str));
        System.out.println(compression2(str));
        char[] chars = str.toCharArray();
        int ans = compression3(chars);
        String res = new String(chars);
        System.out.println(res.substring(0, ans));
    }

}