public class _08_StringReplacement {
    public static String replaceQuestionMarks(String word, String substr) {
        char[] wordChars = word.toCharArray();
        char[] substrChars = substr.toCharArray();

        int start = -1;
        for (int i = 0; i < wordChars.length - substrChars.length + 1; i++) {
            boolean match = true;
            for (int j = 0; j < substrChars.length; j++) {
                if (wordChars[i + j] != substrChars[j] && wordChars[i + j] != '?') {
                    match = false;
                    break;
                }
            }
            if (match) {
                start = i;
                break;
            }
        }

        if (start == -1) {
            return "-1";
        }
        int j = 0;
        for (int i = 0; i < wordChars.length; i++) {
            if (i >= start && i < start + substrChars.length) {
                wordChars[i] = substrChars[j++];
            } else if (wordChars[i] == '?') {
                wordChars[i] = 'a';
            }
        }
        return new String(wordChars);
    }

    public static void main(String[] args) {
        String word = "se??";
        String substr = "abc";

        String result = replaceQuestionMarks(word, substr);
        System.out.println(result); // Output: abcdblacf
    }
}

/*

as?b?e?gf
dbk


??c???er
deciph

se???
abc
 */