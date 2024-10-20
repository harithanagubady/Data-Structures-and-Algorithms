import _03_Basic_Operations_on_SLL._01_SinglyLinkedList;
import _03_Basic_Operations_on_SLL._01_SinglyLinkedList.Node;

/*
https://www.geeksforgeeks.org/find-length-of-a-linked-list-iterative-and-recursive/
 */
public class _02_LengthOfLinkedList {

    public static void main(String[] args) {
        _01_SinglyLinkedList ll = new _01_SinglyLinkedList();
        ll.insertAtEnd(1);
        ll.insertAtEnd(1);
        ll.insertAtEnd(3);
        ll.insertAtEnd(4);
        ll.insertAtEnd(4);
        System.out.println("Input list:");
        System.out.println(_01_SinglyLinkedList.toString(ll.getHead()));
        int lengthRecursive = lengthRecursive(ll.getHead(), 0);
        System.out.println("LengthRecursive:");
        System.out.println(lengthRecursive);
        int lengthIterative = lengthIterative(ll.getHead());
        System.out.println("LengthIterative:");
        System.out.println(lengthIterative);
    }

    public static int lengthRecursive (Node head, int count) {
        if (head == null) return count;
        return lengthRecursive(head.next, count + 1);
    }

    public static int lengthIterative (Node head) {
        int count = 0;
        Node curr = head;
        while (curr != null) {
            count++;
            curr = curr.next;
        }
        return count;
    }
}
