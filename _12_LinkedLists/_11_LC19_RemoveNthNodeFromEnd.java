/*
https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 */

import _03_Basic_Operations_on_SLL._01_SinglyLinkedList;
import _03_Basic_Operations_on_SLL._01_SinglyLinkedList.Node;
public class _11_LC19_RemoveNthNodeFromEnd {

    public static void main(String[] args) {
        _01_SinglyLinkedList ll2 = new _01_SinglyLinkedList();
        ll2.insertAtEnd(5);
        ll2.insertAtEnd(6);
        ll2.insertAtEnd(1);
        ll2.insertAtEnd(2);

        System.out.println(_01_SinglyLinkedList.toString(removeNthFromEnd(ll2.getHead(), 4)));
    }

    public static Node removeNthFromEnd(Node head, int n) {
        if (head == null) return null;
        Node fast = head, slow = head;
        for (int i = 0; i < n; i++) fast = fast.next;
        if (fast == null) return head.next;
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head;
    }
}
