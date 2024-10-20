/* https://leetcode.com/problems/reverse-linked-list-ii/description/ */
package _06_Inplace_Reversal_of_LinkedList;

import _03_Basic_Operations_on_SLL._01_SinglyLinkedList;
import _03_Basic_Operations_on_SLL._01_SinglyLinkedList.Node;

public class _02_LC92_ReverseLinkedList2 {

    public static Node reverseBetweenBruteForce(Node head, int left, int right) {
        if (left >= right) return head;

        //set pointers at correct positions - start
        Node curr = head;
        Node dummy = new Node();
        dummy.next = head;
        Node prev = dummy, next = null;
        Node start = head, end = null;
        for (int i = 1; i < left; i++) {
            prev = curr;
            curr = curr.next;
        }
        start = curr;
        for (int i = left; i < right; i++) {
            curr = curr.next;
        }
        end = curr;
        next = curr.next;
        //set pointers at correct positions - end

        //change links of prev and end nodes
        prev.next = end;
        end.next = null;

        //reverse sub list
        reverse (start);

        //change link of start node
        start.next = next;

        return dummy.next;
    }

    public static void reverse (Node start) {
        Node curr = start.next;
        Node prev = start;
        Node next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
    }

    public static Node reverseBetweenEfficientApproach (Node head, int left, int right) {
        if (left >= right || head == null) return head;

        //set pointers at correct positions - start
        Node dummy = new Node();
        dummy.next = head;

        Node prev = dummy;
        for (int i = 1; i < left; i++) {
            prev = prev.next;
        }

        reversalProcess(left, right, prev);

        return dummy.next;
    }

    private static void reversalProcess(int left, int right, Node prev) {
        Node curr = prev.next;
        Node next = curr.next;

        for (int i = 1; i <= right - left; i++) {
            curr.next = next.next;
            next.next = prev.next;
            prev.next = next;
            next = curr.next;
        }
    }

    public static void main(String[] args) {
        _01_SinglyLinkedList ll = new _01_SinglyLinkedList();
        ll.insertAtEnd(1);
        ll.insertAtEnd(2);
        ll.insertAtEnd(3);
        ll.insertAtEnd(4);
        ll.insertAtEnd(5);
        int left = 2, right = 4;
        Node head = ll.getHead();
        System.out.println("input list: \n" + _01_SinglyLinkedList.toString(head));
        //Node resHead = reverseBetweenBruteForce(head, left, right);
        Node resHead = reverseBetweenEfficientApproach(head, left, right);
        System.out.println("output list: \n" + _01_SinglyLinkedList.toString(resHead));
    }
}
