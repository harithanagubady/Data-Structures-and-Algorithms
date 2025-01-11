/*
https://leetcode.com/problems/sort-vowels-in-a-string/
 */

import java.util.HashMap;

public class _03_LC2785_SortVowels {

    public static String sortVowels(String s) {
        String sortedVowels = "AEIOUaeiou";
        HashMap<Character, Integer> freqMap = new HashMap<>();
        for (char ch : s.toCharArray()) {
            if (sortedVowels.indexOf(ch) == -1) continue;
            freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
        }

        StringBuilder str = new StringBuilder();
        int idxOnVowels = 0, len = sortedVowels.length();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (sortedVowels.indexOf(ch) == -1) {
                str.append(ch);
            } else {
                while(idxOnVowels < len && freqMap.getOrDefault(sortedVowels.charAt(idxOnVowels), 0) == 0) {
                    idxOnVowels++;
                }

                if (idxOnVowels < len) {
                    char vowel = sortedVowels.charAt(idxOnVowels);
                    str.append(vowel);
                    freqMap.put(vowel, freqMap.get(vowel) - 1);
                }
            }
        }

        return str.toString();
    }

    public static void main(String[] args) {
        //String s = "lEetcOde"; //expected = "lEOtcede"

        String s = "lYmpH";//expected = lYmpH
        System.out.println(sortVowels(s));
    }
}
