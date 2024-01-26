public class _06_PrintPermutations {

    public static void main(String[] args) {
        String s = "abc";
        printPermutations(s, "");
    }

    public static void printPermutations(String ques, String ans) {
        if (ques.length() == 0) {
            System.out.println(ans);
            return;
        }

        for (int i = 0; i < ques.length(); i++) {
            char ch = ques.charAt(i);
            String iques1 = ques.substring(0, i);
            String iques2 = ques.substring(i + 1);
            String iques = iques1 + iques2;
            printPermutations(iques, ans + ch);
        }
    }
}
