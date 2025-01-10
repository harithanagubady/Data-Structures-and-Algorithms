package _03_Check_Types_of_String;/*
https://leetcode.com/problems/valid-anagram/
 */

public class _02_LC242_ValidAnagram {

    public static void main(String[] args) {
        String s1 = "abcca";
        String s2 = "bcaac";
        System.out.println(isAnagram(s1, s2));
    }
    public static boolean isAnagram(String s, String t) {

        if (s.length() != t.length()) {
            return false;
        }
        int len1 = s.length();
        int[] charCountS = new int[26];
        for (char ch : s.toCharArray()) {
            charCountS[ch - 'a']++;
        }
        for (char ch : t.toCharArray()) {
            charCountS[ch - 'a']--;
        }
        for (int i : charCountS) {
            if (i != 0) return false;
        }
        return true;
    }
}
