/*
https://leetcode.com/problems/middle-of-the-linked-list/
 */

import _03_Basic_Operations_on_SLL._01_SinglyLinkedList;
import _03_Basic_Operations_on_SLL._01_SinglyLinkedList.Node;

public class _04_LC876_MiddleOfLinkedList {

    public static void main(String[] args) {
        _01_SinglyLinkedList ll = new _01_SinglyLinkedList();
        ll.insertAtHead(1);
        ll.insertAtEnd(2);
        ll.insertAtEnd(3);
        ll.insertAtEnd(4);
        System.out.println(findMiddleBruteForce(ll.getHead()));
        System.out.println(findMiddleFastAndSlowPointer(ll.getHead()));
    }

    static int findMiddleBruteForce (Node head) {
        int mid = _02_LengthOfLinkedList.lengthIterative(head) / 2 + 1;

        Node curr = head;
        for (int i = 0; i < mid - 1; i++) {
            curr = curr.next;
        }
        return curr.data;
    }

    //Tortoise and Hare, Fast and Slow Pointer
    static int findMiddleFastAndSlowPointer (Node head) {

        if (head == null) return -1;
        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow.data;
    }
}
