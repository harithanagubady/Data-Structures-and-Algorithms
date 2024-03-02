import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class _02_BalancedBrackets {

    public static void main(String[] args) {
        Map<Character, Character> map = new HashMap<>();
        map.put('}', '{');
        map.put(')', '(');
        map.put(']', '[');

        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        Stack<Character> stack = new Stack<>();
        for (char ch : str.toCharArray()) {
            if (map.containsKey(ch) && !stack.isEmpty()) {
                while (stack.peek() != map.get(ch)) {
                    stack.pop();
                }
                stack.pop();
            } else {
                stack.push(ch);
            }
        }

        System.out.println(stack.isEmpty());
    }
}
