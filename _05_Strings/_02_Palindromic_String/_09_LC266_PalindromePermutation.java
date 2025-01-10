package _02_Palindromic_String;/*
https://leetcode.com/problems/palindrome-permutation/description/
 */

import java.util.HashSet;
import java.util.Set;

public class _09_LC266_PalindromePermutation {

    public static void main(String[] args) {
        String s = "code";
        System.out.println(canPermutePalindrome(s));
        s = "aab";
        System.out.println(canPermutePalindrome2(s));
    }

    public static boolean canPermutePalindrome(String s) {
        Set<Character> set = new HashSet<>();
        for (char ch : s.toCharArray()) {
            if (!set.add(ch)) set.remove(ch);
        }
        return set.size() == 0 || set.size() == 1;
    }

    //Bit Manipulation
    public static boolean canPermutePalindrome2(String s) {
        int bitMask = 0;
        for (char ch : s.toCharArray()) {
            bitMask ^= (1 << (ch - 'a'));
        }
        return (bitMask & (bitMask - 1)) == 0;
    }
}
