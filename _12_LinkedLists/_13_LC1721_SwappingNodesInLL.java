/*
https://leetcode.com/problems/swapping-nodes-in-a-linked-list/description/
 */

import _03_Basic_Operations_on_SLL._01_SinglyLinkedList;
import _03_Basic_Operations_on_SLL._01_SinglyLinkedList.Node;

public class _13_LC1721_SwappingNodesInLL {

    public static void main(String[] args) {
        _01_SinglyLinkedList ll = new _01_SinglyLinkedList();
        ll.insertAtEnd(1);
        ll.insertAtEnd(2);
        ll.insertAtEnd(3);
        ll.insertAtEnd(4);
        ll.insertAtEnd(5);
        ll.insertAtEnd(6);
        ll.insertAtEnd(7);
        ll.insertAtEnd(8);
        ll.insertAtEnd(9);

        int k = 1;
        Node head = ll.getHead();
        System.out.println("input list: \n" + _01_SinglyLinkedList.toString(head));
        swapNodes(head, k);
        System.out.println("output list: \n" + _01_SinglyLinkedList.toString(head));
    }

    public static void swapNodes(Node head, int k) {
        Node slow = head;
        Node fast = head;
        for (int i = 1; i < k; i++) {
            fast = fast.next;
        }

        Node first = fast;

        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        //swap
        int tmp = first.data;
        first.data = slow.data;
        slow.data = tmp;

    }
}
