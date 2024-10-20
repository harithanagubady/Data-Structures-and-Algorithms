/*
https://leetcode.com/problems/delete-node-in-a-linked-list/description/
 */

import _03_Basic_Operations_on_SLL._01_SinglyLinkedList;
import _03_Basic_Operations_on_SLL._01_SinglyLinkedList.Node;

public class _08_LC237_DeleteNodeFromLL {

    public static void main(String[] args) {
        _01_SinglyLinkedList ll = new _01_SinglyLinkedList();
        ll.insertAtHead(1);
        ll.insertAtEnd(2);
        ll.insertAtEnd(3);
        ll.insertAtEnd(4);
        Node node = ll.getHead().next.next;
        System.out.println("Input list:");
        System.out.println(_01_SinglyLinkedList.toString(ll.getHead()));
        deleteNode(node);
        System.out.println("Output list:");
        System.out.println(_01_SinglyLinkedList.toString(ll.getHead()));
    }

    public static void deleteNode(Node node) {
        node.data = node.next.data;
        node.next = node.next.next;
    }
}
