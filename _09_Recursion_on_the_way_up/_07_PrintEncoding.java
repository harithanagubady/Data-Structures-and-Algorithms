import java.util.Scanner;

public class _07_PrintEncoding {

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        printEncoding(str, "");
    }

    private static void printEncoding(String str, String ans) {
        if (str.length() == 0) {
            System.out.println(ans);
        } else if (str.length() == 1) {
            if (str.equals("0")) return;
            int num = Integer.parseInt(str); // eg: 6
            //convert to corresponding alphabet //'f'
            char ch = (char) ('a' + num - 1);
            System.out.println(ans + ch);
        } else {

            int num1 = Integer.parseInt(str.substring(0, 1));
            if(num1 == 0) return;
            char ch1 = (char) ('a' + num1 - 1);
            String remStr1 = str.substring(1);
            printEncoding(remStr1, ans + ch1);

            int num2 = Integer.parseInt(str.substring(0, 2));
            if (num2 > 26) return;
            char ch2 = (char) ('a' + num2 - 1);
            String remStr2 = str.substring(2);
            printEncoding(remStr2, ans + ch2);
        }
    }
}
