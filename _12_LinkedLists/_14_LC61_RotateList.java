import _03_Basic_Operations_on_SLL._01_SinglyLinkedList;
import _03_Basic_Operations_on_SLL._01_SinglyLinkedList.Node;

/*
https://leetcode.com/problems/rotate-list/
 */
public class _14_LC61_RotateList {

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

        int k = 3;
        Node head = ll.getHead();
        System.out.println("input list: \n" + _01_SinglyLinkedList.toString(head));
        Node resHead = rotateList(head, k);
        //Node resHead = reverseInKGroupIterative(head, k);
        System.out.println("output list: \n" + _01_SinglyLinkedList.toString(resHead));
    }

    private static Node rotateList(Node head, int k) {
        if (head == null) {
            return null;
        }
        Node slow = head, fast = head;
        int size = 1;
        while (fast.next != null) {
            size++;
            fast = fast.next;
        }
        k %= size;

        for (int i = 1; i < size - k; i++) {
            slow = slow.next;
        }

        fast.next = head;
        head = slow.next;
        slow.next = null;
        return head;
    }
}
