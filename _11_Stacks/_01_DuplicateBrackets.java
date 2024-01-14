import java.util.Scanner;
import java.util.Stack;

public class _01_DuplicateBrackets {

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        String inputStr = scn.nextLine();
        boolean status = solution(inputStr);
        System.out.println(status);
    }

    private static boolean solution(String inputStr) {
        Stack<Character> charStack = new Stack<>();
        for (char ch : inputStr.toCharArray()) {
            if (ch == ')') {
                if(charStack.peek() == '(') {
                    return true;
                } else {
                    while (charStack.peek() != '(') {
                        charStack.pop();
                    }
                    charStack.pop();
                }
            } else {
                charStack.push(ch);
            }
        }
        return false;
    }
}
