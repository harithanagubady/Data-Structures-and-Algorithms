package _06_Inplace_Reversal_of_LinkedList;

import _03_Basic_Operations_on_SLL._01_SinglyLinkedList;
import _03_Basic_Operations_on_SLL._01_SinglyLinkedList.Node;

/*
https://leetcode.com/problems/palindrome-linked-list/description/
 */
public class _05_LC234_PalindromeLL {

    public static void main(String[] args) {
        _01_SinglyLinkedList ll = new _01_SinglyLinkedList();
        ll.insertAtEnd(1);
        ll.insertAtEnd(2);
        ll.insertAtEnd(3);
        ll.insertAtEnd(3);
        ll.insertAtEnd(2);
        ll.insertAtEnd(1);

        Node head = ll.getHead();
        System.out.println("input list: \n" + _01_SinglyLinkedList.toString(head));
        //boolean palindrome = isPalindrome(head);
        boolean palindrome = isPalindromeRecursive(head);
        System.out.println(palindrome);
    }

    //Fast And Slow pointer
    public static boolean isPalindrome(Node head) {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        Node prev = slow;
        slow = slow.next;
        prev.next = null;
        while (slow != null) {
            Node temp = slow.next;
            slow.next = prev;
            prev = slow;
            slow = temp;
        }
        fast = head;
        slow = prev;
        while (slow != null) {
            if (slow.data != fast.data) return false;
            slow = slow.next;
            fast = fast.next;
        }
        return true;
    }

    static Node curr;
    public static boolean isPalindromeRecursive(Node head) {
        curr = head;
        return solve(head);
    }

    private static boolean solve(Node head) {
        if(head == null) return true;
        boolean ans = solve(head.next) && head.data == curr.data;
        curr = curr.next;
        return ans;
    }
}
