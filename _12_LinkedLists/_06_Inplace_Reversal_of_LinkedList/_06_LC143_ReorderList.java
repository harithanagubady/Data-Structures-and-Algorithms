package _06_Inplace_Reversal_of_LinkedList;

import _03_Basic_Operations_on_SLL._01_SinglyLinkedList;
import _03_Basic_Operations_on_SLL._01_SinglyLinkedList.Node;

/* https://leetcode.com/problems/reorder-list/description/
 */
public class _06_LC143_ReorderList {

    public static void main(String[] args) {
        _01_SinglyLinkedList ll = new _01_SinglyLinkedList();
        ll.insertAtEnd(1);
        ll.insertAtEnd(2);
        ll.insertAtEnd(3);
        ll.insertAtEnd(4);
        ll.insertAtEnd(5);
        ll.insertAtEnd(6);
        ll.insertAtEnd(7);

        Node head = ll.getHead();
        System.out.println("input list: \n" + _01_SinglyLinkedList.toString(head));
        reorderList(head);
        System.out.println("output list: \n" + _01_SinglyLinkedList.toString(head));
    }

    public static void reorderList(Node head) {

        if (head == null || head.next == null) return;
        //Find middle of LinkedList 1->2->3->4->5->6
        Node slow = head;
        Node fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        Node prev = slow;
        Node curr = slow.next;

        //Reverse second half of LinkedList 1->2->3->6->5->4
        //insert next between prev and prev.next
        while (curr.next != null) {
            Node next = curr.next;
            curr.next = next.next;
            next.next = prev.next;
            prev.next = next;
        }

        //Start re-order 1->2->3->6->5->4 to 1->6->2->5->3->4
        fast = head;
        slow = prev.next;

        while (fast != prev) {
            prev.next = slow.next;
            slow.next = fast.next;
            fast.next = slow;
            fast = slow.next;
            slow = prev.next;
        }
    }
}
