package _06_Inplace_Reversal_of_LinkedList;

/*
https://leetcode.com/problems/reverse-nodes-in-k-group/
 */
import _03_Basic_Operations_on_SLL._01_SinglyLinkedList;
import _03_Basic_Operations_on_SLL._01_SinglyLinkedList.Node;

public class _03_LC25_ReverseNodesInKGroup {

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
        _01_SinglyLinkedList.Node head = ll.getHead();
        System.out.println("input list: \n" + _01_SinglyLinkedList.toString(head));
        //_01_SinglyLinkedList.Node resHead = reverseInKGroupRecursive(head, k);
        _01_SinglyLinkedList.Node resHead = reverseInKGroupIterative(head, k);
        System.out.println("output list: \n" + _01_SinglyLinkedList.toString(resHead));
    }

    public static Node reverseInKGroupRecursive(Node head, int k) {
        if (head == null) return head;
        int count = 0;
        Node nextHead = head;
        while (count < k && nextHead != null) {
            nextHead = nextHead.next;
            count++;
        }

        if (count < k) return head;

        Node reversedNextHead = reverseInKGroupRecursive(nextHead, k);
        Node first = reversedNextHead; //first tracks the first Node of reversed-so-far
        while (count-- > 0) {
            Node tmpHead = head.next;
            head.next = first;
            first = head;
            head = tmpHead;
        }
        head = first;
        return head;
    }

    public static Node reverseInKGroupIterative(Node head, int k) {
        if (head == null) return head;
        Node dummy = new Node();
        dummy.next = head;
        Node prev = dummy;
        Node curr = head;
        int count = 1;
        while (curr != null) {
            if (count % k == 0) {
                prev = reverse (prev, curr.next);
                curr = prev.next;
            } else {
                curr = curr.next;
            }
            count++;
        }
        return dummy.next;
    }

    private static Node reverse(Node beg, Node end) {
        Node curr = beg.next;
        Node prev = beg;
        Node next = null;
        Node first = curr;
        while (curr != end) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        beg.next = prev;
        first.next = end;
        return first;
    }
}
