/*
https://leetcode.com/problems/remove-duplicates-from-sorted-list/
 */

import _03_Basic_Operations_on_SLL._01_SinglyLinkedList;
import _03_Basic_Operations_on_SLL._01_SinglyLinkedList.Node;

public class _03_LC83_RemoveDuplicatesFromSortedList {

    public static void main(String[] args) {
        _01_SinglyLinkedList ll = new _01_SinglyLinkedList();
        ll.insertAtEnd(1);
        ll.insertAtEnd(1);
        ll.insertAtEnd(3);
        ll.insertAtEnd(4);
        ll.insertAtEnd(4);
        System.out.println("Input list:");
        System.out.println(_01_SinglyLinkedList.toString(ll.getHead()));
        Node resHead = deleteDuplicates(ll.getHead());
        System.out.println("Output list:");
        System.out.println(_01_SinglyLinkedList.toString(resHead));
    }

    public static Node deleteDuplicates(Node head) {
        if (head == null) return null;

        // Initialize the current node as the head of the list.
        Node current = head;

        // Traverse through the list until the end is reached.
        while (current.next != null) {
            // If the next node is a duplicate, bypass it.
            if (current.next.data == current.data) {
                current.next = current.next.next;
            } else {
                // If not, move to the next node.
                current = current.next;
            }
        }
        // Return the modified head of the list.
        return head;
    }


}
