package _06_Inplace_Reversal_of_LinkedList;
/*
https://leetcode.com/problems/reverse-linked-list/description/
 */
import _03_Basic_Operations_on_SLL._01_SinglyLinkedList;
import _03_Basic_Operations_on_SLL._01_SinglyLinkedList.Node;

public class _01_LC206_ReverseLinkedList {

    private static Node reverse (Node prev, Node curr) {
        if (curr == null) return prev;
        Node next = curr.next;
        curr.next = prev;
        return reverse (curr, next);
    }

    public static Node reverseListRecursive(Node head) {
        if (head == null) return head;
        return reverse (null, head);
    }

    public static Node reverseListIterative(Node head) {

        if (head == null) return head;
        Node prev = null;
        Node curr = head;
        Node next = null;


        /*
        1 -> 2 -> 3
        null <- 1    2 -> 3
        null <- 1 <- 2    3
        null <- 1 <- 2 <- 3

         */
        while (curr != null) {
            next = curr.next;
            curr.next = prev;

            prev = curr;
            curr = next;
        }

        head = prev;
        return head;
    }
    
    public static void main(String[] args) {
        _01_SinglyLinkedList ll = new _01_SinglyLinkedList();
        ll.insertAtEnd(1);
        ll.insertAtEnd(2);
        ll.insertAtEnd(3);
        ll.insertAtEnd(4);
        ll.insertAtEnd(5);
        System.out.println("Input list:");
        System.out.println(_01_SinglyLinkedList.toString(ll.getHead()));
        Node resHead = reverseListIterative(ll.getHead());
        System.out.println("Output list:");
        System.out.println(_01_SinglyLinkedList.toString(resHead));
    }
}
