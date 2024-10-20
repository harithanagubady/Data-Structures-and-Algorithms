/*
https://www.geeksforgeeks.org/check-doubly-linked-list-characters-palindrome-not/
 */

import _04_Basic_Operations_on_DLL._01_DoublyLinkedList;
import _04_Basic_Operations_on_DLL._01_DoublyLinkedList.Node;

public class _12_PalindromDLL {

    public static void main(String[] args) {
        _01_DoublyLinkedList dll = new _01_DoublyLinkedList();
        dll.insertAtEnd(4);
        dll.insertAtEnd(1);
        dll.insertAtEnd(1);
        dll.insertAtEnd(1);
        System.out.println(isPalindrome(dll.head));
    }

    public static boolean isPalindrome(Node head) {
        if (head == null || head.next == null) return true;

        Node tail = head;
        while (tail.next != null) tail = tail.next; // Find the tail of the doubly linked list

        Node start = head;
        Node end = tail;

        while (start != end && start.prev != end) {
            if (start.val != end.val) return false; // Compare the values at start and end pointers
            start = start.next;
            end = end.prev;
        }

        return true;
    }
}
