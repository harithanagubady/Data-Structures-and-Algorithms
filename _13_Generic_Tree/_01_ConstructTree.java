import java.util.ArrayList;
import java.util.Stack;

public class _01_ConstructTree {

    private static class Node {
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }

    public static void main(String[] args) {
        int[] arr = {10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 130, -1, -1, -1};
        Stack<Node> stack = new Stack<>();
        Node root = new Node();
        for (int j : arr) {
            if (j == -1) {
                stack.pop();
            } else {
                Node t = new Node();
                t.data = j;
                if (stack.size() > 0) {
                    stack.peek().children.add(t);
                } else {
                    root = t;
                }
                stack.push(t);
            }
        }
        display(root);
    }

    private static void display (Node n) {
        StringBuilder str = new StringBuilder(n.data + " -> ");
        for (Node child : n.children) {
            str.append(child.data).append(", ");
        }
        str.append(".");
        System.out.println(str);
        for (Node n1 : n.children) {
            display(n1);
        }
    }
}
