public class _01_PrintSubSequence {

    public static void main(String[] args) {
        String s = "abc";
        printSS(s, "");
    }

    public static void printSS(String ques, String ans) {
        if (ques.length() == 0) {
            System.out.println(ans);
            return;
        }

        char ch = ques.charAt(0);
        String iques = ques.substring(1);

        printSS(iques, ans + ch);
        printSS(iques, ans);
    }
}
